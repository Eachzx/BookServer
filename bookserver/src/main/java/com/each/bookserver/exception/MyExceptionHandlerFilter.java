package com.each.bookserver.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: bookserver
 * @Package: com.each.bookserver.exception
 * @Description: 最外层filter处理验证token、登录认证和授权过滤器中抛出的所有异常
 * @Author: zhangxu
 * @CreateDate: 2019/4/13 16:37
 * @UpdateUser: zhangxu
 * @UpdateDate: 2019/4/13 16:37
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2019
 */
@Slf4j
public class MyExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            httpServletResponse.setCharacterEncoding("utf-8");
            httpServletResponse.getWriter().write(e.getMessage());
        }
    }
}
