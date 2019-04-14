package com.each.bookserver.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @ProjectName: bookserver
 * @Package: com.each.bookserver.util
 * @Description:  序列化对象
 *                 Include.ALWAYS  是序列化对像所有属性
 *                 Include.NON_NULL 只有不为null的字段才被序列化
 *                 Include.NON_EMPTY 如果为null或者 空字符串和空集合都不会被序列化
 * @Author: zhangxu
 * @CreateDate: 2019/4/12 13:59
 * @UpdateUser: zhangxu
 * @UpdateDate: 2019/4/12 13:59
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2019
 */
public class ObjectMapperUtil {
    static ObjectMapper objectMapper = new ObjectMapper();

    public static ObjectMapper getObjectMapper(){
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        /**
         * Include.ALWAYS  是序列化对像所有属性
         * Include.NON_NULL 只有不为null的字段才被序列化
         * Include.NON_EMPTY 如果为null或者 空字符串和空集合都不会被序列化
         */
        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        //如果是空对象的时候,不抛异常,也就是对应的属性没有get方法
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        //取消时间的转化格式,默认是时间戳,可以取消,同时需要设置要表现的时间格式
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        //反序列化的时候如果多了其他属性,不抛出异常
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    public static Object readValue(String json,Class c) {
        try {
            return getObjectMapper().readValue(json,c);
        }catch (IOException e){
            return null;
        }
    }

    public static String writeAsString(Object o){
        try {
            return getObjectMapper().writeValueAsString(o);
        }catch (JsonProcessingException e){
            return e.getMessage();
        }
    }
}
