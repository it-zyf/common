package com.javaboy.common.controller.stream;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.excel.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: zyf
 * @create: 2022-04-15 18:04
 **/
public class StreamTest {
    @Test
    public void testFilter() {
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo("1", "捡田螺的小男孩", 18, Arrays.asList("1","2")));
        userInfoList.add(new UserInfo("2", "程序员田螺", 27,Arrays.asList("1","2")));
        userInfoList.add(new UserInfo("3", "捡瓶子的小男孩", 26,Arrays.asList("1","2")));
        List<String> list = new ArrayList<>();
        list.add(null);
        userInfoList.add(new UserInfo("4","123",27,list));
        for (UserInfo userInfo : userInfoList) {
            userInfo.getHobby().removeAll(Collections.singleton(null));
            System.out.println(userInfo.getHobby().size());
            if(CollUtil.isNotEmpty(userInfo.getHobby())){
                System.out.println(userInfo.getHobby());
            }
        }

//        List<UserInfo> collect = userInfoList.stream().filter(userInfo -> CollUtil.isNotEmpty(userInfo.getHobby())).collect(Collectors.toList());
//        System.out.println(JSON.toJSONString(collect));

//        List<UserInfo> collect = userInfoList.stream().filter(userInfo -> {
//            UserInfo userInfo1 = new UserInfo();
//            userInfo1.setUserId("1");
//            if (BeanUtil.isEmpty(userInfo1)) {
//                return false;
//            }
//            return StrUtil.isBlank(userInfo.getUserId()) || Objects.equals(userInfo1.getUserId(), userInfo.getUserId());
//        }).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(userInfoList));

    }

    /**
     * flatmap 操作完之后还是一个集合
     */
    @Test
    public void testFlatmap() {
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo("1", "捡田螺的小男孩", 18,Arrays.asList("1","2")));
        userInfoList.add(new UserInfo("2", "程序员田螺", 27,Arrays.asList("1","2")));
        userInfoList.add(new UserInfo("3", "捡瓶子的小男孩", 26,Arrays.asList("1","2")));
        List<List<UserInfo>> lists = new ArrayList<>();
        lists.add(userInfoList);
        Set<String> collect = lists.stream()
                .flatMap(i -> i.stream()
                        .map(UserInfo::getUserId))
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toSet());
        System.out.println(collect);

    }

    /**
     * peek 想当于foreach 有一个集合的返回值
     *
     */
    @Test
    public void tstPeek(){
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo("1", "捡田螺的小男孩", 18,Arrays.asList("1","2")));
        userInfoList.add(new UserInfo("2", "程序员田螺", 27,Arrays.asList("1","2")));
        userInfoList.add(new UserInfo("3", "捡瓶子的小男孩", 26,Arrays.asList("1","2")));
        List<UserInfo> collect = userInfoList.stream().peek(userInfo -> userInfo.setUserId("123")).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
    }

    @Test
    public void test(){
        HashMap<String, Long> map = Maps.newHashMap();
        map.put("1",123L);
        map.put("2",23L);
        map.put("3",2L);

        map.replaceAll((k, v) -> -v);
        System.out.println(JSON.toJSONString(map));

    }

}
