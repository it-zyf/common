package com.javaboy.common.everyTest;

import cn.hutool.core.bean.BeanUtil;
import com.javaboy.common.entity.HH;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: zyf
 * @create: 2021-08-27 17:47
 **/
public class Test12 {
    @Test
    public void test() {
        HH hh = new HH();
        hh.setId(1);
        hh.setName("李白");
        HH hh1 = BeanUtil.toBean(hh, HH.class);
        System.out.println(hh1);
    }

    @Test
    public void test1() {
        String we = "nmsl123";
        String s = Stream.of(we).skip(1).map(l -> "*").skip(we.length()).toString();
        System.out.println(s);

    }

    @Test
    public void test2() {
        List<String> strList = new ArrayList<String>();
        Collections.addAll(strList, "A-1-中-我", "A-1-国-没", "A-2-人-有", "A-2-民-钱", "B-1-银-肿", "B-2-行-么", "B-2-行-办");

        Map<String, Map<String, Map<String, List<String>>>> map = strList.stream().map(m -> {
            return m.split("-");
        }).collect(Collectors.groupingBy(k -> k[0], Collectors.groupingBy(k -> k[1], Collectors.groupingBy(k -> k[2], Collectors.collectingAndThen(Collectors.toList(), m -> m.stream().map(f -> f[3]).collect(Collectors.toList()))))));

        System.out.println(map);

    }

    @Test
    public void test3() {
        String str = "11,12,13,1101,1102,1201,1301";
        List<String> collect = Arrays.stream(str.split(",")).map(String::valueOf).filter(l -> l.length() == 2).collect(Collectors.toList());
        ArrayList<List<String>> lists = new ArrayList<>();
        for (String s : collect) {
            ArrayList<String> strings = new ArrayList<>();
            String[] split = str.split(",");
            for (int i = 0; i < split.length; i++) {
                String substring = split[i].substring(0, 2);
                if (s.equals(split[i].substring(0, 2))) {
                    strings.add(split[i]);
                }
            }
            lists.add(strings);
        }
        System.out.println(lists);
    }

    @Test
    public void test4() {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("age","17");
        System.out.println(concurrentHashMap.get("age"));
        concurrentHashMap.remove("age");
        System.out.println(concurrentHashMap.get("age"));

    }


}
