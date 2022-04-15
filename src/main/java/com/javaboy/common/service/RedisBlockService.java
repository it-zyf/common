package com.javaboy.common.service;

import com.javaboy.common.controller.redis.Msg;
import com.javaboy.common.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: zyf
 * @create: 2022-04-02 10:52
 **/
@Slf4j
@Service
public class RedisBlockService {
    @Autowired
    private RedissonClient redissonClient;

    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate redis;

    private static final String REDIS_MQ = "data_for_es";

    /**
     * 发送消息到队列头部
     *
     * @param map
     */
    public void sendMessage(Map map) {
        RBlockingDeque<Map> blockingDeque = redissonClient.getBlockingDeque(REDIS_MQ);
        try {
            blockingDeque.putFirst(map);
            log.info("将消息: {} 插入到队列。", map);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void sendMessage2(User user) {
        Msg msg = new Msg();
        msg.setUser(user);
        msg.setFlag("1");
        redis.convertAndSend(REDIS_MQ,msg);
    }
}
