package com.javaboy.common.everyTest;

import cn.hutool.core.bean.BeanUtil;
import com.javaboy.common.entity.HH;
import org.junit.Test;

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
    public void test1(){
        String we="nmsl123";
        String s = Stream.of(we).skip(1).map(l -> "*").skip(we.length()).toString();
        System.out.println(s);

    }
}
