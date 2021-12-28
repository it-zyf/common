package com.javaboy.common.controller.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author v-zhangyafeng3
 */
@RestController
@RequestMapping("/redis")
public class RedisTest {
  @Autowired
  StringRedisTemplate redisTemplate;

    @RequestMapping("/test")
    public String test() {
        redisTemplate.opsForValue().set("name","张三");
        String name = redisTemplate.opsForValue().get("name");
        return name;

    }

    @RequestMapping("/test2")
    public String test2() {
        redisTemplate.opsForValue().set("age", "17",60 * 10, TimeUnit.SECONDS);
        return "ok";
    }

    @RequestMapping("/test3")
    public String test3() {
        String age = (String) redisTemplate.opsForValue().get("age");
        System.out.println(age);
        redisTemplate.delete("age");
        return "ok";
    }

}
