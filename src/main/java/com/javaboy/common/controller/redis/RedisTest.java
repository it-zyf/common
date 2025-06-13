package com.javaboy.common.controller.redis;

import com.alibaba.fastjson.JSON;
import com.javaboy.common.constant.CodeConstant;
import com.javaboy.common.entity.User;
import com.javaboy.common.util.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author v-zhangyafeng3
 */
@RestController
@RequestMapping("/redis")
public class RedisTest {
  @Autowired
  StringRedisTemplate redisTemplate;

    @RequestMapping("/test")
    public String test() {
        redisTemplate.opsForValue().set("name","张三");
        String name = redisTemplate.opsForValue().get("name");
        return name;

    }

    @RequestMapping("/test2")
    public String test2() {
        redisTemplate.opsForValue().set("age", "17",60 * 10, TimeUnit.SECONDS);
        return "ok";
    }

    @RequestMapping("/test3")
    public String test3() {
        String age = (String) redisTemplate.opsForValue().get("age");
        System.out.println(age);
        redisTemplate.delete("age");
        return "ok";
    }


    @RequestMapping("/set")
    public void set() {
       redisTemplate.opsForValue().set("_common_token_key","123",6,TimeUnit.HOURS);
    }


    @RequestMapping("/get")
    public void get() {
        if(Boolean.FALSE.equals(redisTemplate.hasKey("_common_token_key"))){
            System.out.println("key 失效生成新的key ");
            redisTemplate.opsForValue().set("_common_token_key", CodeConstant.TOKEN,6, TimeUnit.HOURS);
        }
    }

    @GetMapping("/util/set")
    public void redisUtilSet(){
        //List<T>
        List<Msg> list = new ArrayList<>();
        User user = new User();
        Msg msg = new Msg();
        msg.setFlag("1");
        msg.setUser(user);
        list.add(msg);
        RedisUtils.set("userList", list);
        //T
        RedisUtils.set("user",msg);
        //
        RedisUtils.set("string","123");

    }


    @GetMapping("/util/get")
    public void redisUtilGet(){
        //list
        List<Msg> userList = RedisUtils.getList("userList",Msg.class);
        System.out.println(JSON.toJSONString(userList));

        //bean
        Msg msg = RedisUtils.get("user", Msg.class);
        System.out.println(msg);

        //
        String str = RedisUtils.getStr("string");

        System.out.println(str);
    }

}
