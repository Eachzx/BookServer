package com.each.bookserver.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;


/**
 * @ProjectName: bookserver
 * @Package: com.each.bookserver.security
 * @Description:  用户登出处理器
 * @Author: zhangxu
 * @CreateDate: 2019/4/13 16:06
 * @UpdateUser: zhangxu
 * @UpdateDate: 2019/4/13 16:06
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2019
 */
@Slf4j
public class MyLogoutFilter   extends LogoutFilter {

    public MyLogoutFilter(MyLogoutSuccessHandler logoutSuccessHandler, MyLogoutHandler logoutHandler,String filterProcessesUrl) {
        super(logoutSuccessHandler, logoutHandler);
        //更改默认的登出URL
//        super.setFilterProcessesUrl(filterProcessesUrl);
    }

    /**
     * 使用此构造方法，会使用默认的SimpleUrlLogoutSuccessHandler
     * 在登出成功后重定向到指定的logoutSuccessUrl
     * @param logoutSuccessUrl
     * @param handler
     */
    public MyLogoutFilter(String logoutSuccessUrl, MyLogoutHandler handler) {
        super(logoutSuccessUrl, handler);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        super.doFilter(req, res, chain);
    }
}