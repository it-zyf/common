package com.javaboy.common.config;

/**
 * @author: zyf
 * @create: 2021-09-24 09:54
 **/
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


//@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, String> redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(redisKeySerializer());
        redisTemplate.setValueSerializer(redisKeySerializer());
        redisTemplate.setHashKeySerializer(redisKeySerializer());
        redisTemplate.setDefaultSerializer(redisKeySerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    public RedisSerializer<?> redisKeySerializer() {
        return new StringRedisSerializer();
    }


}
