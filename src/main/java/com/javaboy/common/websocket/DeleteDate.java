package com.javaboy.common.websocket;

import com.javaboy.common.controller.EchoChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zyf
 * @date 2024/10/17 16:31
 */
@Service
@Slf4j
public class DeleteDate {


    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void delete() throws InterruptedException {
        //业务代码。。。。。
        Thread.sleep(1000);


        EchoChannel.sendMsg("123");

    }
}
