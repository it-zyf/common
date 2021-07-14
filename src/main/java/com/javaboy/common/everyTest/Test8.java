package com.javaboy.common.everyTest;

import org.junit.Test;

public class Test8 {
    @Test
    public void test(){
        String  a="adfaf";
        String[] split = a.split("/");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }

    }

}
