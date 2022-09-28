package com.javaboy.common;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import springfox.documentation.oas.annotations.EnableOpenApi;


/**
 * @author zyf
 */
@SpringBootApplication
@MapperScan({"com.javaboy.common.mapper",
        "com.javaboy.common.controller.redis.hotsort.dao.mapper",
        "com.javaboy.common.controller.user.dao.mapper",
        "com.javaboy.common.controller.easyexcel.dao.mapper",
        "com.javaboy.common.*.*.mapper"})
@EnableOpenApi
@EnableAsync
@EnableCaching
@EnableScheduling
public class CommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }

    @Bean
    public Snowflake snowflake() {
        return IdUtil.getSnowflake(1, 1);
    }


    @Bean
    public ThreadPoolTaskExecutor createThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(15);
        threadPoolTaskExecutor.setMaxPoolSize(31);
        threadPoolTaskExecutor.setKeepAliveSeconds(3);
        threadPoolTaskExecutor.setThreadNamePrefix("thread-execute");
        return threadPoolTaskExecutor;
    }

}
