package com.javaboy.common.alltest;

import cn.hutool.core.lang.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author : zyf
 * @date : 2022/9/9 15:05
 */
public class Test17 {
    /**
     * 断言测试
     */
    @Test
    public void test() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        Assert.notNull(list,"查询列表数据不能为空");
    }



}
