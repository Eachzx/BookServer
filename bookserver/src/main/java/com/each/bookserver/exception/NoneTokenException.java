package com.each.bookserver.exception;

/**
 * @ProjectName: bookserver
 * @Package: com.each.bookserver.webEnum
 * @Description: 用户未登录异常处理类
 * @Author: zhangxu
 * @CreateDate: 2019/4/13 15:54
 * @UpdateUser: zhangxu
 * @UpdateDate: 2019/4/13 15:54
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2019
 */
public class NoneTokenException  extends RuntimeException{

    public NoneTokenException(String msg){
        super(msg);
    }

    public NoneTokenException(String msg, Throwable t){
        super(msg,t);
    }
}
