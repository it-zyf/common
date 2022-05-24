package com.javaboy.common.alltest;

import cn.hutool.core.util.ObjectUtil;
import org.junit.Test;

/**
 *
 * @author: zyf
 * @create: 2022-03-21 15:19
 **/
public class Test16 {
    @Test
    public void test(){
        StringBuilder sb = new StringBuilder();
        sb.append("zhangsan");
        sb.append(',');
        System.out.println(sb.toString());
    }

    @Test
    public void test2(){
        System.out.println(ObjectUtil.notEqual("1", null));
    }
}
