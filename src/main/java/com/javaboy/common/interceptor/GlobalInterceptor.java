package com.javaboy.common.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : zyf
 * @date : 2022/5/24 11:30
 */
@Configuration
public class GlobalInterceptor implements WebMvcConfigurer {

    @Bean
    public GlobalInterceptorImpl getGlobalInterceptorImpl(){
        return new GlobalInterceptorImpl();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getGlobalInterceptorImpl())
                .addPathPatterns("/**");
    }

}
