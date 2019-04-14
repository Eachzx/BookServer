package com.each.bookserver.exception;

/**
 * @ProjectName: bookserver
 * @Package: com.each.bookserver.exception
 * @Description: token过期异常类
 * @Author: zhangxu
 * @CreateDate: 2019/4/13 16:16
 * @UpdateUser: zhangxu
 * @UpdateDate: 2019/4/13 16:16
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2019
 */
public class TokenIsExpiredException extends RuntimeException {

    public TokenIsExpiredException(String msg){
        super(msg);
    }

    public TokenIsExpiredException(String msg, Throwable t){
        super(msg,t);
    }
}

