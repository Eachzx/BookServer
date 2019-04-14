package com.each.bookserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ProjectName: bookserver
 * @Package: com.each.bookserver.config
 * @Description: Swagger配置类
 * @Author: zhangxu
 * @CreateDate: 2019/4/11 11:36
 * @UpdateUser: zhangxu
 * @UpdateDate: 2019/4/11 11:36
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2019
 */
@EnableSwagger2
@Configuration
@ComponentScan("com.each.bookserver.controller")
public class SwaggerConfigure {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.each.bookserver.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("EACH-图书管理系统-API")
                .description("EACHBookAPI")
                .termsOfServiceUrl("http://each.com")
                .version("1.0")
                .build();
    }
}

