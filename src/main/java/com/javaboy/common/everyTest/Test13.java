package com.javaboy.common.everyTest;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;

/**
 * @author yayu
 * @title: Test13
 * @description: TODO
 * @date 2021/10/26 15:39
 */
public class Test13 {
    @Test
    public void test(){
        String hh="2021-10-26 15:00:00";
        String nowStr = DateUtil.now();
        if(hh.compareTo(nowStr)<0) {
            System.out.println("hhhhh");
        }
        DateTime parse = DateUtil.parse(hh);

    }
}
