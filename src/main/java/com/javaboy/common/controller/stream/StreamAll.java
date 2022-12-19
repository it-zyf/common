package com.javaboy.common.controller.stream;

import com.javaboy.common.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zyf
 */
public class StreamAll {

    /**
     * list 转换 map
     */
    @Test
    public void mapToList() {
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo("1", "捡田螺的小男孩", 18, Arrays.asList("1","2")));
        userInfoList.add(new UserInfo("2", "程序员田螺", 27,Arrays.asList("1","2")));
        userInfoList.add(new UserInfo("3", "捡瓶子的小男孩", 26,Arrays.asList("1","2")));

        /**
         *  list 转 map
         *  使用Collectors.toMap的时候，如果有可以重复会报错，所以需要加(k1, k2) -> k1
         *  (k1, k2) -> k1 表示，如果有重复的key,则保留第一个，舍弃第二个
         */
        Map<String, UserInfo> userInfoMap = userInfoList.stream().collect(Collectors.toMap(UserInfo::getUserId, userInfo -> userInfo, (k1, k2) -> k1));
        userInfoMap.values().forEach(a -> System.out.println(a.getName()));


    }

    /**
     * map 转换成新的List使用
     */
    @Test
    public void mapTest() {
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo("1", "捡田螺的小男孩", 18,Arrays.asList("1","2")));
        userInfoList.add(new UserInfo("2", "程序员田螺", 27,Arrays.asList("1","2")));
        userInfoList.add(new UserInfo("3", "捡瓶子的小男孩", 26,Arrays.asList("1","2")));
        List<User> collect = userInfoList.stream().map(userInfo -> {
            User user = new User();
            user.setAge(userInfo.getAge());
            return user;
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    public void ListToMap(){
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo("1", "捡田螺的小男孩", 18,Arrays.asList("1","2")));
        userInfoList.add(new UserInfo("2", "程序员田螺", 27,Arrays.asList("1","2")));
        userInfoList.add(new UserInfo("3", "捡瓶子的小男孩", 26,Arrays.asList("1","2")));
        Map<String, UserInfo> collects = userInfoList.stream().collect(Collectors.toMap(UserInfo::getUserId, Function.identity()));
        System.out.println(collects);



    }

}
