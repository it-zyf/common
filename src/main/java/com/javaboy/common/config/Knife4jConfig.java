package com.javaboy.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * @author yayu
 * @title: SwaggerConfig
 * @description:   Swagger2 配置
 * @date 2021/1/28 10:58
 */
@Configuration
@EnableOpenApi
public class Knife4jConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.javaboy.common.controller.swaggerController"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("common")
                        .description("SpringBoot+mybatisPlus 的一套公共的项目")
                        .version("1.0")
                        .contact(new Contact("zyf", "localhost:9009/", "aaa@gmail.com"))
                        .license("The Apache License")
                        .licenseUrl("https://github.com/it-yayu?tab=repositories")
                        .build());
    }

}
