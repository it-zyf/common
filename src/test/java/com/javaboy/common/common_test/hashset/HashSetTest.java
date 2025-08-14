package com.javaboy.common.common_test.hashset;

import java.util.HashSet;

/**
 * @author zyf
 * @date 2025/8/11 16:49
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("a");
        boolean a = set.add("a");
        System.out.println(a);
        System.out.println(set);
    }
}
