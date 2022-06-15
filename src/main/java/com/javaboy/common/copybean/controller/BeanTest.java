package com.javaboy.common.copybean.controller;

import com.google.common.collect.Lists;
import com.javaboy.common.copybean.entity.PersonDto;
import com.javaboy.common.copybean.entity.User;
import com.javaboy.common.util.BeanConvertUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author: zyf
 * @create: 2022-06-13 15:34
 **/
public class BeanTest {
    @Test
    public void test() {
        User user = User.builder().userName("张三").age("20").sex(1).hobby(Arrays.asList("1", "2", "3")).gay(true).build();
        PersonDto personDto = BeanConvertUtils.convertTo(user, PersonDto::new);
        System.out.println(personDto);
    }

    @Test
    public void test2() {
        List<User> userList = createUser();
        List<PersonDto> persons = BeanConvertUtils.convertListTo(userList, PersonDto::new);
        Optional.of(persons).orElseGet(ArrayList::new).forEach(System.out::println);
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
