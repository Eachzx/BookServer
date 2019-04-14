package com.each.bookserver.security;

import com.each.bookserver.entity.MyUserDetails;
import com.each.bookserver.exception.WrongUsernameException;
import com.each.bookserver.webEnum.AuthErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;

/**
 * @ProjectName: bookserver
 * @Package: com.each.bookserver.security
 * @Description: 用户认证管理器
 * @Author: zhangxu
 * @CreateDate: 2019/4/12 13:26
 * @UpdateUser: zhangxu
 * @UpdateDate: 2019/4/12 13:26
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2019
 */
@Slf4j
public class MyAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    public BCryptPasswordEncoder passwordEncoder;

    public MyAuthenticationProvider(UserDetailsService userDetailsService, BCryptPasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //authentication,登录url提交的需要被认证的对象。只含有用户名和密码，需要根据用户名和密码来校验，并且授权。
        String username=authentication.getName();
        String password= (String) authentication.getCredentials();
        MyUserDetails userDetails= (MyUserDetails) userDetailsService.loadUserByUsername(username);
        if (userDetails==null){
            log.warn("没有找到用户名：{}"+username);
            throw new WrongUsernameException(AuthErrorEnum.LOGIN_NAME_ERROR.getMessage());
        }
        //如果从url提交的密码到数据保存的密码没有经过加密或者编码，直接比较是否相同即可。如果在添加用户时的密码是经过加密或者编码的应该使用对应的加密算法和编码工具对密码进行编码之后再进行比较
        if (!password.equals(userDetails.getPassword())){
            log.warn("密码错误");
            throw  new WrongUsernameException(AuthErrorEnum.LOGIN_PASSWORD_ERROR.getMessage());
        }
        Collection<? extends GrantedAuthority> authorities=userDetails.getAuthorities();
        return new UsernamePasswordAuthenticationToken(userDetails,password,authorities);
    }
}
