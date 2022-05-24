package com.javaboy.common.controller.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : zyf
 * @date : 2022/5/20 17:20
 */
@RestController
@RequestMapping("/redisHash")
public class RedisForHash {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/set")
    public String set() {
        HashMap<String, String> map = new HashMap<>(3);
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        redisTemplate.opsForHash().putAll("userId",map);
        return "ok";
    }

    @RequestMapping("/set2")
    public String set2() {
        HashMap<String, String> map = new HashMap<>(3);
        map.put("4", "4");
        map.put("5", "5");
        map.put("6", "6");
        redisTemplate.delete("userId");
        redisTemplate.opsForHash().putAll("userId",map);
        return "ok";
    }

    @RequestMapping("/get")
    public Map get(){
        HashMap<String, String> map = (HashMap<String, String>) redisTemplate.opsForHash().entries("hh").get("userId");
        Collection<String> values = map.values();
        return map;
    }
}
