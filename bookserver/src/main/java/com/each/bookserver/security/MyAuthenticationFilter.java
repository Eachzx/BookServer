package com.each.bookserver.security;

import com.each.bookserver.exception.IllegalTokenAuthenticationException;
import com.each.bookserver.exception.NoneTokenException;
import com.each.bookserver.exception.TokenIsExpiredException;
import com.each.bookserver.util.JwtUtil;
import com.each.bookserver.util.PathUtil;
import com.each.bookserver.webEnum.AuthErrorEnum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: bookserver
 * @Package: com.each.bookserver.security
 * @Description: 除了/login,/logout,所有URI都会进入  token验证过滤器
 * @Author: zhangxu
 * @CreateDate: 2019/4/13 15:44
 * @UpdateUser: zhangxu
 * @UpdateDate: 2019/4/13 15:44
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2019
 */
@Slf4j
public class MyAuthenticationFilter   extends BasicAuthenticationFilter {
    private String tokenHeader;

    private String head;

    private UserDetailsService userDetailsService;

    private List<String> permitRegexUris;

    public MyAuthenticationFilter(AuthenticationManager authenticationManager, String tokenHeader, String head, UserDetailsService userDetailsService,String permitUris) {
        super(authenticationManager);
        this.head = head;
        this.tokenHeader = tokenHeader;
        this.userDetailsService = userDetailsService;
        this.permitRegexUris = Arrays.asList(permitUris.split(",")).stream().map(s -> {
            return PathUtil.getRegPath(s);
        }).collect(Collectors.toList());
    }

    /**
     * 判断请求是否是否带有token信息，token是否合法，是否过期。设置安全上下文。
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader(tokenHeader);
        //可能是登录或者注册的请求，不带token信息，又或者是不需要登录，不需要token即可访问的资源。
//        String uri = request.getRequestURI();
//        for (String regexPath:permitRegexUris){
//            if (Pattern.matches(regexPath,uri)){
//                chain.doFilter(request,response);
//                return;
//            }
//        }
        if (token == null) {
            log.warn("请登录访问");
            throw new NoneTokenException(AuthErrorEnum.TOKEN_NEEDED.getMessage());
        }
        if (!token.startsWith(head)) {
            log.warn("token信息不合法");
            throw new IllegalTokenAuthenticationException(AuthErrorEnum.AUTH_HEADER_ERROR.getMessage());
        }
        Claims claims = JwtUtil.getClaim(token.substring(head.length()));
        if (claims == null) {
            throw new TokenIsExpiredException(AuthErrorEnum.TOKEN_EXPIRED.getMessage());
        }
        String userName = claims.getSubject();
        if (userName == null) {
            throw new TokenIsExpiredException(AuthErrorEnum.TOKEN_EXPIRED.getMessage());
        }
        Date expiredTime = claims.getExpiration();
        if ((new Date().getTime() > expiredTime.getTime())) {
            log.warn("当前token信息已过期,请重新登录");
            throw new TokenIsExpiredException(AuthErrorEnum.TOKEN_EXPIRED.getMessage());
        }
        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            log.info("用户：{}，正在访问：{}", userName, request.getRequestURI());
            logger.info("authenticated user " + userName + ", setting security context");
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        }
    }
}
