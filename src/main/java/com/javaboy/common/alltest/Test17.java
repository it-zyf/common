package com.javaboy.common.alltest;

import cn.hutool.core.bean.BeanUtil;
import com.javaboy.common.entity.User;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : zyf
 * @date : 2022/9/9 15:05
 */
public class Test17 {

    @Test
    public void test() {
        List<String> list = new LinkedList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add(0, "5");


        for (String s : list) {
            System.out.println(s);
        }

    }

    @Test
    public void test2() {
        User user = new User();
        if (BeanUtil.isEmpty(user)) {
            System.out.println(123);
        }

    }

}
