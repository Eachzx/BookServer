package com.each.bookserver.security;

import com.each.bookserver.exception.MyExceptionHandlerFilter;
import com.each.bookserver.service.MyUserDetailsService;
import com.each.bookserver.service.PermissionService;
import com.each.bookserver.service.impl.PermissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * @ProjectName: bookserver
 * @Package: com.each.bookserver.security
 * @Description: security配置类
 * @Author: zhangxu
 * @CreateDate: 2019/4/11 13:34
 * @UpdateUser: zhangxu
 * @UpdateDate: 2019/4/11 13:34
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2019
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.head}")
    private String head;

    @Value("${jwt.expired}")
    private boolean expired;

    @Value("${jwt.expiration}")
    private int expiration;

    @Value("${jwt.permitUris}")
    private String permitUris;

    @Autowired
    private PermissionServiceImpl permissionService;


    @Bean
    public UserDetailsService myUserDetailsService(){
        return new MyUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new MyAuthenticationProvider(myUserDetailsService(),passwordEncoder()));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .cors()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(permitUris.split(",")).permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .and()
                .addFilterBefore(new MyExceptionHandlerFilter(), LogoutFilter.class)
                .addFilter(new MyLogoutFilter(new MyLogoutSuccessHandler(),new MyLogoutHandler(tokenHeader,head),"/logout"))
                .addFilter(new MyLoginFilter(authenticationManager(),head,tokenHeader,permissionService))
                .addFilter(new MyAuthenticationFilter(authenticationManager(),tokenHeader,head,myUserDetailsService(),permitUris));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    /**
     * 解决跨域问题
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
