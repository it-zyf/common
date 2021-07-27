package com.javaboy.common.everyTest;

import cn.hutool.core.date.DateUtil;

import java.util.ArrayList;

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




}
