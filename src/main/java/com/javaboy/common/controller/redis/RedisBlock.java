package com.javaboy.common.controller.redis;

import com.javaboy.common.entity.User;
import com.javaboy.common.service.RedisBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zyf
 * @create: 2022-04-02 10:51
 **/
@RestController
@RequestMapping("redis")
public class RedisBlock {
    @Autowired
    private RedisBlockService redisBlockService;

    @RequestMapping("/send")
    public void testQueue(){
        User user = new User();
        user.setName("zs");
        user.setAge(19);
        redisBlockService.sendMessage(user);
    }

    @RequestMapping("/send2")
    public void testQueue2(){
        User user = new User();
        user.setName("zs");
        user.setAge(19);
        redisBlockService.sendMessage2(user);
    }

}
