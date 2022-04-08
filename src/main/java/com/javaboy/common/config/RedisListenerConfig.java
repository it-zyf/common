package com.javaboy.common.config;

import com.javaboy.common.controller.redis.lister.RedisListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @author: zyf
 * @create: 2022-04-02 14:24
 **/
@Configuration
public class RedisListenerConfig {
    @Autowired
    private RedisListener redisListener;

    private static final String REDIS_MQ = "redisMQ";
    @Bean
     public RedisMessageListenerContainer container( RedisConnectionFactory factory) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();

        container.setConnectionFactory(factory);

        container.addMessageListener(redisListener, new PatternTopic(REDIS_MQ));

        return container;

    }
}
