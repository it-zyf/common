package com.javaboy.common.controller.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author v-zhangyafeng3
 */
@RestController
@RequestMapping("/redis")
public class RedisTest {
  @Autowired
  RedisTemplate redisTemplate;

    @RequestMapping("/test")
    public String test() {
        redisTemplate.opsForValue().set("name","张三");
        String name = (String) redisTemplate.opsForValue().get("name");
        return name;

    }
}
