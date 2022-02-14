package com.javaboy.common.controller.redis;

import cn.hutool.core.util.IdUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: zyf
 * @create: 2022-02-11 15:14
 **/
@RestController
@RequestMapping("/redisList")
@RequiredArgsConstructor
@Slf4j
public class RedisTestForList {

    private final StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/add")
    public String test() {
        String toke1 = IdUtil.simpleUUID();
        stringRedisTemplate.opsForValue().set(toke1,"1");
        stringRedisTemplate.opsForList().leftPush("1",toke1);
        String toke2 = IdUtil.simpleUUID();
        stringRedisTemplate.opsForList().leftPush("2",toke2);
        stringRedisTemplate.opsForValue().set(toke2,"2");
        String toke3 = IdUtil.simpleUUID();
        stringRedisTemplate.opsForValue().set(toke3,"1");
        stringRedisTemplate.opsForList().leftPush("1",toke3);
        return "ok";
    }


    @RequestMapping("/query")
    public String test2() {
        List<String> range = stringRedisTemplate.opsForList().range("1", 0, -1);
        Optional.ofNullable(range).orElse(new ArrayList<>()).forEach(log::info);
        return "ok";
    }

    @RequestMapping("/del")
    public String test3() {
        List<String> range = stringRedisTemplate.opsForList().range("2", 0, -1);
        Optional.ofNullable(range).orElse(new ArrayList<>()).forEach(stringRedisTemplate::delete);
        stringRedisTemplate.delete("2");
        return "ok";
    }

}
