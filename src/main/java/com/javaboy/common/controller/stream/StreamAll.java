package com.javaboy.common.controller.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zyf
 */
public class StreamAll {

    /**
     * list 转换 map
     */
    @Test
    public void mapToList(){
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo("1", "捡田螺的小男孩", 18));
        userInfoList.add(new UserInfo("2", "程序员田螺", 27));
        userInfoList.add(new UserInfo("3", "捡瓶子的小男孩", 26));

        /**
         *  list 转 map
         *  使用Collectors.toMap的时候，如果有可以重复会报错，所以需要加(k1, k2) -> k1
         *  (k1, k2) -> k1 表示，如果有重复的key,则保留第一个，舍弃第二个
         */
        Map<String, UserInfo> userInfoMap = userInfoList.stream().collect(Collectors.toMap(UserInfo::getUserId, userInfo -> userInfo, (k1, k2) -> k1));
        userInfoMap.values().forEach(a->System.out.println(a.getName()));


    }
}
