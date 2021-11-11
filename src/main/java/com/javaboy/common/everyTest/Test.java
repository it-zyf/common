package com.javaboy.common.everyTest;

import cn.hutool.core.date.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class Test {
    @org.junit.Test
    public void test1() {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> strings2 = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings2.add("1");
        strings2.add("2");
        strings2.add("3");

        System.out.println(!strings.containsAll(strings2));
    }


    @org.junit.Test
    public void test2() {
        String format = DateUtil.format(DateUtil.date(), "yyyyMMddHHmmss");
        System.out.println(format);
    }


    @org.junit.Test
    public void test3() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(1);
        integers.add(2);
        integers.add(3);

        List<Integer> list = conversionList(integers);
        System.out.println(list);
    }

    /**
     * 数组向右移动
     *
     * @param list 原数组
     * @param b    移动的位数
     * @return 移动后b位后得到的数组
     */
    public static List<Integer> rightMove(List<Integer> list, int b) {
        int originSize = list.size();
        b = originSize - b % originSize;
        for (int i = 0; i < b; i++) {
            list.add(list.get(i));
        }
        return list.subList(list.size() - originSize, list.size());
    }


    public static List<Integer> conversionList(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                continue;
            }
            newList.add(list.get(i));
        }
        while (newList.size() < 6) {
            newList.add(0);
        }
        newList.add(list.get(0));
        return newList;
    }


}
