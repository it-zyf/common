package com.javaboy.common.controller.redis;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author zyf
 * @date 2023/1/17 14:29
 */
@RequestMapping("/redisson")
@RestController
public class RedissonTest {
    @Resource
    private RedissonClient redissonClient;


    @RequestMapping("/test")
    public void test(){
        RLock lock = redissonClient.getLock("123");
        try {
            boolean isLock = lock.tryLock(10, 100, TimeUnit.SECONDS);
            if (!isLock) {
                throw new RuntimeException("获取锁失败");
            }
            System.out.println(123);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
