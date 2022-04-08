package com.javaboy.common.controller.redis.lister;


import com.javaboy.common.controller.redis.Msg;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @author: zyf
 * @create: 2022-04-02 14:20
 **/
@Component
public class RedisListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] bytes) {
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
        Msg msg = (Msg)serializer.deserialize(message.getBody());
        System.out.println(msg.getUser());
        System.out.println(msg.getFlag());
    }
}
