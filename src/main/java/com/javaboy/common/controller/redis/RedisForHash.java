package com.javaboy.common.controller.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
@SuppressWarnings("unchecked")
public class RedisForHash {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @RequestMapping("/set")
    public String set() {
        HashMap<String, String> map = new HashMap<>(3);
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        stringRedisTemplate.opsForHash().putAll("userId",map);
        return "ok";
    }


    @RequestMapping("/set2")
    public String set2() {
        HashMap<String, String> map = new HashMap<>(3);
        map.put("4", "4");
        map.put("5", "5");
        map.put("6", "6");
        stringRedisTemplate.delete("userId");
        stringRedisTemplate.opsForHash().putAll("userId",map);
        return "ok";
    }

    @RequestMapping("/get")
    public Map get(){
        HashMap<String, String> map = (HashMap<String, String>) stringRedisTemplate.opsForHash().entries("hh").get("userId");
        Collection<String> values = map.values();
        return map;
    }



    @RequestMapping("/addMap")
    public String add(){
        HashMap<String, String> map = new HashMap<>(3);
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        redisTemplate.opsForHash().put("singledb_dev","123",map);
        return "ok";
    }


    @RequestMapping("/addMap2")
    public String add2(){
        HashMap<String, String> map = new HashMap<>(3);
        map.put("4", "4");
        map.put("5", "5");
        map.put("6", "6");
        redisTemplate.opsForHash().put("singledb_dev","456",map);
        return "ok";
    }

    @RequestMapping("/getMap2")
    public Map<String, String> get2(){
        Map<String, String> singledbDev = (Map<String, String>) redisTemplate.opsForHash().get("singledb_dev", "123");
        System.out.println(singledbDev);
        return singledbDev;
    }

    @RequestMapping("/delMap")
    public String  delMap(){
        redisTemplate.opsForHash().delete("singledb_dev","123");
        return "ok";
    }

}
