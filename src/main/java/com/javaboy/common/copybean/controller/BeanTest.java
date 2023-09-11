package com.javaboy.common.copybean.controller;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.javaboy.common.copybean.entity.PersonDto;
import com.javaboy.common.copybean.entity.User;
import com.javaboy.common.util.BeanConvertUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: zyf
 * @create: 2022-06-13 15:34
 **/
public class BeanTest {
    @Test
    public void test() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("zhangsan","1");
        User user = User.builder().userName("张三").age("20").sex(1).hobby(Lists.newArrayList("0","1","2")).gay(true).map(map).build();
        PersonDto personDto = BeanConvertUtils.convertTo(user, PersonDto::new);
        System.out.println(personDto);
        PersonDto personDto1 = BeanUtil.copyProperties(user, PersonDto.class);
        System.out.println(personDto1);
    }

    @Test
    public void test2() {
        List<User> userList = createUser();
        List<PersonDto> persons = BeanConvertUtils.convertListTo(userList, PersonDto::new);
        System.out.println(JSON.toJSONString(persons,true));
        List<PersonDto> personDtos = BeanUtil.copyToList(userList, PersonDto.class);
        System.out.println(JSON.toJSONString(personDtos,true));

    }


    private List<User> createUser(){
        List<User> userList = Lists.newArrayList();
        User user = User.builder().userName("张三").age("20").sex(1).hobby(Arrays.asList("1", "2", "3")).gay(true).build();
        User user2 = User.builder().userName("李四").age("21").sex(0).hobby(Arrays.asList("1", "2", "3")).gay(false).build();
        userList.add(user);
        userList.add(user2);
        return userList;
    }
}
