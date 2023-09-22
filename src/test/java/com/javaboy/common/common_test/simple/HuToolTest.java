package com.javaboy.common.common_test.simple;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;

/**
 * @author zyf
 * @date 2023/8/18 14:13
 */
public class HuToolTest {

    @org.junit.Test
    public void test(){
        String a ="";
        String b ="";
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("1");

//        Assert.notBlank(a,"不能为空");


        Assert.isFalse(StrUtil.isBlank(a) && StrUtil.isBlank(b), "参数异常");


        Assert.notEmpty(objects,"集合不能为空");


        Assert.isFalse(objects.contains("1"),"不能通过");

    }

}
