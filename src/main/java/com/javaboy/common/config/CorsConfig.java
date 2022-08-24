package com.javaboy.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局跨域问题
 * @author : zyf
 * @date : 2022/8/24 15:11
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    private static final  String[] PARAM =new String[]{"GET", "POST", "PUT", "DELETE"};
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //是否发送Cookie
                //放行哪些原始域
                .allowedOrigins("*")
                .allowedMethods(PARAM)
                .allowedHeaders("*")
                .exposedHeaders("*");
    }
}
