package com.javaboy.common.redis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author zyf
 * @date 2023/8/16 10:26
 */
@SpringBootTest
public class RedisTest {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void test(){
        Long topo_port_order = redisTemplate.opsForValue().increment("topo_port_order");
        long l = (long) redisTemplate.opsForValue().get("topo_port_order");
        redisTemplate.opsForValue().set("topo_port_order",l);
        System.out.println(topo_port_order);

    }

    @Test
    public void test1(){

        redisTemplate.opsForValue().set("topo_port_order1","12321");

        Object topo_port_order1 = redisTemplate.opsForValue().get("topo_port_order1");
        System.out.println(topo_port_order1);
    }

    @org.junit.Test
    public void test2() {
        int a =1 ;
        System.out.println(Long.valueOf(a));
    }

}
