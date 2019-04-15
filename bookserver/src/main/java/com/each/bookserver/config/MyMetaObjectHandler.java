package com.each.bookserver.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ProjectName: bookserver
 * @Package: com.each.bookserver.config
 * @Description: 设置公共填充字段
 * @Author: zhangxu
 * @CreateDate: 2019/4/15 10:27
 * @UpdateUser: zhangxu
 * @UpdateDate: 2019/4/15 10:27
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2019
 */
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {

        metaObject.setValue("updateTime", new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateTime", new Date(), metaObject);
    }

}
