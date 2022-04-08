package com.javaboy.common.config;

/**
 * @author: zyf
 * @create: 2021-09-24 09:54
 **/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){

        RedisTemplate<String, Object> template = new RedisTemplate<>();

        template.setConnectionFactory(redisConnectionFactory);

        // string序列化方式

        RedisSerializer serializer = new GenericJackson2JsonRedisSerializer();

        // 设置默认序列化方式

        template.setDefaultSerializer(serializer);

        template.setKeySerializer(new StringRedisSerializer());

        template.setHashValueSerializer(serializer);


        return template;
    }


}
