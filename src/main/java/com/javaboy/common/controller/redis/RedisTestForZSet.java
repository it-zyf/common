package com.javaboy.common.controller.redis;

import cn.hutool.core.util.IdUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
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
@RequiredArgsConstructor
@Slf4j
@SuppressWarnings("rawtypes")
public class RedisTestForZSet {

    private final StringRedisTemplate stringRedisTemplate;

    private final RedisTemplate redisTemplate;

    private static final String KEY = "hh";

    @RequestMapping("/add")
    public String test() {
        String value = IdUtil.simpleUUID();
        stringRedisTemplate.opsForZSet().add(KEY, value, System.currentTimeMillis());
        String key2 = IdUtil.simpleUUID();
        log.info(key2);
        String value2 = IdUtil.simpleUUID();
        log.info(value2);
        stringRedisTemplate.opsForZSet().add(KEY, value2, System.currentTimeMillis());
        return "ok";
    }


    @RequestMapping("/del")
    public String test2(String val) {
        stringRedisTemplate.opsForZSet().remove("hh", val);
        return "ok";
    }


    @RequestMapping("/addTwo")
    public String test3(String val) {
        stringRedisTemplate.opsForZSet().add("user_token_set_e4f45a2b0e735823dda63990ebdc856b", val, System.currentTimeMillis());
        return "ok";
    }


    @RequestMapping("/delAll")
    public String test2() {
        //50秒
        long now = System.currentTimeMillis() - 50000;
        Set<String> strings = stringRedisTemplate.opsForZSet().rangeByScore(KEY, 0, now);
        Optional.ofNullable(strings).orElse(new HashSet<>()).forEach(string -> {
            stringRedisTemplate.opsForZSet().remove(KEY, string);
            log.info(string);
        });
        return "ok";
    }

    @RequestMapping("/delKey")
    public String test4() {
        stringRedisTemplate.delete("user_token_set_e4f45a2b0e735823dda63990ebdc856b");
        return "ok";
    }



    @RequestMapping("/getAll")
    public String test5() {
        Set<String> se = stringRedisTemplate.opsForZSet().range("user_token_set_e4f45a2b0e735823dda63990ebdc856b",System.currentTimeMillis()-21600000, System.currentTimeMillis());
        if(CollectionUtils.isEmpty(se) || !se.contains("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJlNGY0NWEyYjBlNzM1ODIzZGRhNjM5OTBlYmRjODU2YiIsInN1YiI6IuW8gOWPkUIiLCJpYXQiOjE2NDU1MTc1NDJ9.CEjJB1zg5PE-t-ls5NGcENBgSXEq2RnMRpptonT3d6k")){
            return "no";
        }
        return "yes";
    }



}