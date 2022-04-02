package com.javaboy.common.controller.redis;

import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.service.RedisBlockService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author: zyf
 * @create: 2022-04-02 11:01
 **/
@Component
public class RedisBlockCus {
    @Autowired
    private RedisBlockService2 redisBlockService2;

    @Scheduled(cron = "*/5 * * * * ?")
    public ResponseMsg restoreCreditScoreTask() {
        redisBlockService2.onMessage();
        return ResponseMsg.success();
    }
}
