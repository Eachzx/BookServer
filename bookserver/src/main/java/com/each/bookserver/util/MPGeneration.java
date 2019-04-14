package com.each.bookserver.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @ProjectName: bookserver
 * @Package: com.each.bookserver.util
 * @Description: mybatisPlus代码生成器
 * @Author: zhangxu
 * @CreateDate: 2019/4/11 11:41
 * @UpdateUser: zhangxu
 * @UpdateDate: 2019/4/11 11:41
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2019
 */
public class MPGeneration {
        private static MPGeneration single = null;

        private MPGeneration() {
            super();
        }

        private static MPGeneration getSingle() {
            if(single == null) {
                single =new MPGeneration();
            }
            return single;
        }

        public void autoGeneration() {
            GlobalConfig config = new GlobalConfig();
            String dbUrl = "jdbc:mysql://120.79.141.204:3306/security?serverTimezone=GMT%2B8";
            DataSourceConfig dataSourceConfig = new DataSourceConfig();
            dataSourceConfig.setDbType(DbType.MYSQL)
                    .setUrl(dbUrl)
                    .setUsername("root")
                    .setPassword("123456")
                    .setDriverName("com.mysql.cj.jdbc.Driver");
            StrategyConfig strategyConfig = new StrategyConfig();
            strategyConfig
                    .setCapitalMode(true) // 全局大写命名 ORACLE 注意
                    .setEntityLombokModel(true) //生成Lombok注解
                    //.setDbColumnUnderline(true)
                    .setTablePrefix("t_")  // 此处可以修改为您的表前缀(数组)
                    .setNaming(NamingStrategy.underline_to_camel);  // 表名生成策略
            config.setActiveRecord(false)
                    .setEnableCache(false) // XML 二级缓存
                    .setSwagger2(true) // model swagger2
                    .setAuthor("each")
                    //指定输出文件夹位置
                    .setOutputDir("E:\\resultEcah\\后端\\bookserver\\src\\main\\java")
                    .setFileOverride(true)
                    .setServiceName("%sService");
            new AutoGenerator().setGlobalConfig(config)
                    .setDataSource(dataSourceConfig)
                    .setStrategy(strategyConfig)
                    .setPackageInfo(
                            new PackageConfig()
                                    .setParent("com.each.bookserver")
                                    .setController("controller")
                                    .setEntity("entity")
                    ).execute();
        }

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            MPGeneration generator = MPGeneration.getSingle();
            generator.autoGeneration();
        }


}
