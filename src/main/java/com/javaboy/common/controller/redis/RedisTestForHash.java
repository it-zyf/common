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

    private final static String KEY="hh";

    @RequestMapping("/add")
    public String test() {
        String value = IdUtil.simpleUUID();
        stringRedisTemplate.opsForZSet().add(KEY, value, System.currentTimeMillis());
        String key2 = IdUtil.simpleUUID();
        System.out.println(key2);
        String value2 = IdUtil.simpleUUID();
        System.out.println(value2);
        stringRedisTemplate.opsForZSet().add(KEY, value2, System.currentTimeMillis());
        return "ok";
    }



    @RequestMapping("/del")
    public String test2(String val) {
        stringRedisTemplate.opsForZSet().remove("hh",val);
        return "ok";
    }


    @RequestMapping("/addTwo")
    public String test3(String val){
        stringRedisTemplate.opsForZSet().add(KEY, val, System.currentTimeMillis());
        return "ok";
    }


    @RequestMapping("/delAll")
    public String test2() {
        //50秒
        long now =System.currentTimeMillis()-50000;
        Set<String> strings = stringRedisTemplate.opsForZSet().rangeByScore(KEY, 0,now);
        Optional.ofNullable(strings).orElse(new HashSet<>()).forEach(string->{
            stringRedisTemplate.opsForZSet().remove(KEY,string);
            System.out.println(string);
        });
        return "ok";
    }


}
