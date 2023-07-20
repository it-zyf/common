package com.javaboy.common.common_test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zyf
 * @date 2023/7/5 15:26
 */
public class ListTest {
    public static void main(String[] args) {
        // 创建两个集合
        List<String> list1 = new ArrayList<>();
        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//        list1.add("3");
//        list1.add("4");
//        list1.add("5");
//        list1.add("6");

        Set<String> set2 = new HashSet<>();
//        set2.add("8");
//        set2.add("9");
//        set2.add("10");

        ArrayList<Object> objects = new ArrayList<>();
        objects.add("1");

        // 取交集
        List<String> collect = Stream.concat(list1.stream(), set2.stream()).collect(Collectors.toList());
        System.out.println(collect);
        Optional<String> intersection = collect.stream()
                .filter(objects::contains)
                .findFirst();
        System.out.println(intersection.orElse(null));

//        list1.retainAll(set2);

//        System.out.println(JSON.toJSON(list1));
    }
}
