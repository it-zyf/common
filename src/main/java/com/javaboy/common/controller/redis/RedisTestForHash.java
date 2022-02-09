package com.javaboy.common.controller.redis;

import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author: zyf
 * @create: 2022-02-09 09:50
 **/
@RestController
@RequestMapping("/redisHash")
public class RedisTestForHash {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    private final String key="hh";

    @RequestMapping("/add")
    public String test() {
        String value = IdUtil.simpleUUID();
        stringRedisTemplate.opsForZSet().add(key, value, System.currentTimeMillis());
        String key2 = IdUtil.simpleUUID();
        System.out.println(key2);
        String value2 = IdUtil.simpleUUID();
        System.out.println(value2);
        stringRedisTemplate.opsForZSet().add(key, value2, System.currentTimeMillis());
        return "ok";
    }



    @RequestMapping("/del")
    public String test2(String val) {
        stringRedisTemplate.opsForZSet().remove("hh",val);
        return "ok";
    }


    @RequestMapping("/addTwo")
    public String test3(String val){
        stringRedisTemplate.opsForZSet().add(key, val, System.currentTimeMillis());
        return "ok";
    }


    @RequestMapping("/delAll")
    public String test2() {
        //两分钟
        long now =System.currentTimeMillis()-50000;
        Set<String> strings = stringRedisTemplate.opsForZSet().rangeByScore(key, 0,now);
        Optional.ofNullable(strings).orElse(new HashSet<>()).forEach(string->{
            stringRedisTemplate.opsForZSet().remove(key,string);
            System.out.println(string);
        });
        return "ok";
    }


}
