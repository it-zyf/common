package com.javaboy.common.everyTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * @author yayu
 * @title: Test7
 * @description: TODO
 * @date 2021/1/25 16:51
 */
public class Test7 {
    @Test
    public void test() {
        HashMap<String, String> map = new HashMap<>();
        map.put("张三", "123");
        map.put("张三", "456");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getValue());
        }
    }
}
