package com.each.bookserver.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: bookserver
 * @Package: com.each.bookserver.util
 * @Description: 获取post请求工具类
 * @Author: zhangxu
 * @CreateDate: 2019/4/12 13:55
 * @UpdateUser: zhangxu
 * @UpdateDate: 2019/4/12 13:55
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2019
 */
@Slf4j
public class GetPostRequestContentUtil {

    public static String getRequestBody(HttpServletRequest request){
        try {
            //获取requestBody中的内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String wholeStr = "";
            String str;
            //一行一行的读取body体里面的内容；
            while ((str = reader.readLine())!= null){
                wholeStr += str;
            }
            return wholeStr;
        }catch (IOException e){
            log.error("获取request流失败");
            return null;
        }
    }
}
