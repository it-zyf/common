package com.javaboy.common.controller.redis;

import com.alibaba.fastjson.JSON;
import com.javaboy.common.entity.EsEntity;
import com.javaboy.common.entity.User;
import com.javaboy.common.service.RedisBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

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
        HashMap<String, Object> map = new HashMap<>(2);
        EsEntity esEntity = new EsEntity();
        esEntity.setAssetsName("hhh");
        esEntity.setId("123");
        esEntity.setLoopId("666");
        map.put("entity", JSON.toJSONString(esEntity));
        map.put("type","insert");
        redisBlockService.sendMessage(map);
    }

    @RequestMapping("/send2")
    public void testQueue2(){
        User user = new User();
        user.setName("zs");
        user.setAge(19);
        redisBlockService.sendMessage2(user);
    }

}
