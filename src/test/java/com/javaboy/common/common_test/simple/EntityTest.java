package com.javaboy.common.common_test.simple;

import com.alibaba.fastjson.JSON;
import com.javaboy.common.entity.User;
import org.apache.ibatis.binding.BindingException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zyf
 * @date 2023/10/30 17:27
 */
public class EntityTest {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        User user = new User();
        user.setId("1");

        User user2 = new User();
        user2.setId("2");

        users.add(user);
        users.add(user2);


        List<String> collect = users.stream().map(User::getId).map(String::toLowerCase).collect(Collectors.toList());
        boolean flag = collect.contains("2");
        User user1 = users.stream()
                .filter(d->flag ? "2".equalsIgnoreCase(d.getId()) : "1".equalsIgnoreCase(d.getId()))
                .findFirst()
                .orElseThrow(() -> new BindingException("该工程默认可用域存在问题"));

        System.out.println(JSON.toJSONString(user1));


    }
}
