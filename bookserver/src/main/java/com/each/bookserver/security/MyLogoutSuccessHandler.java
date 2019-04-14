package com.each.bookserver.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: bookserver
 * @Package: com.each.bookserver.security
 * @Description: 登出成功处理器
 * @Author: zhangxu
 * @CreateDate: 2019/4/13 16:03
 * @UpdateUser: zhangxu
 * @UpdateDate: 2019/4/13 16:03
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2019
 */
@Slf4j
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        log.info("登出成功！");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.getWriter().write("登出成功");
    }
}
