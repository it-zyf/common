package com.javaboy.common.everyTest;

import cn.hutool.core.util.NumberUtil;
import com.javaboy.common.entity.HH;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author yayu
 * @title: Test8
 * @description: TODO
 * @date 2021/3/19 14:22
 */
public class Test8 {
    @Test
    public void test(){
        ArrayList<HH> list = new ArrayList<>();
        HH hh = new HH();
        hh.setName("zhang");
        HH hh1 = new HH();
        hh1.setName("li");
        list.add(hh);
        list.add(hh1);
        String s = Optional.ofNullable(hh).map(h->h.getName()).get().split("a")[1];
        System.out.println(s);

        String s1 = NumberUtil.roundStr(1231.2211111111, 2);
        System.out.println(s1);

        String  a="123";
        String[] split = a.split(",");
        System.out.println(split[0]);


    }

    @Test
    public  void test2(){
        System.out.println(NumberUtil.roundStr(192.1129292,2));
    }
}
