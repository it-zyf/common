package com.javaboy.common.everyTest;

import org.junit.Test;

import java.util.ArrayList;

public class Test8 {
    @Test
    public void test(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        if(strings.contains("4")){
            strings.add("5");
//            List<String> collect = strings.stream().filter(i -> !i.equals("1")).collect(Collectors.toList());
//            collect.forEach(l-> System.out.println(l));
            strings.forEach(l-> System.out.println(l));
        }
    }

}
