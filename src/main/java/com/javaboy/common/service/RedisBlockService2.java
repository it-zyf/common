package com.javaboy.common.service;

import com.javaboy.common.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zyf
 * @create: 2022-04-02 10:53
 **/
@Slf4j
@Service
public class RedisBlockService2 {
    @Autowired
    private RedissonClient redissonClient;

    private static final String REDIS_MQ = "redisMQ";

    /**
     * 从队列尾部阻塞读取消息，若没有消息，线程就会阻塞等待新消息插入，防止 CPU 空转
     */
    public void onMessage() {
        RBlockingDeque<User> blockingDeque = redissonClient.getBlockingDeque(REDIS_MQ);
        while (!blockingDeque.isEmpty()) {
            try {
                System.out.println(1);
                User user= blockingDeque.takeLast();
                System.out.println(2);
                log.info("从队列 {} 中读取到消息：{}.", REDIS_MQ, user);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
