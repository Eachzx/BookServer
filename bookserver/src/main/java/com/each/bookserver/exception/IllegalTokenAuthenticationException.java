package com.each.bookserver.exception;

/**
 * @ProjectName: bookserver
 * @Package: com.each.bookserver.exception
 * @Description: token信息不合法异常类
 * @Author: zhangxu
 * @CreateDate: 2019/4/13 15:58
 * @UpdateUser: zhangxu
 * @UpdateDate: 2019/4/13 15:58
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2019
 */
public class IllegalTokenAuthenticationException extends RuntimeException {

    public IllegalTokenAuthenticationException(String msg){
        super(msg);
    }

    public IllegalTokenAuthenticationException(String msg, Throwable t){
        super(msg,t);
    }
}

