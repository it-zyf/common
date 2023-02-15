package com.javaboy.common.alltest;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.RandomUtil;
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

    @Test
    public void test1(){
        Long aLong = new Long(99L);
        Integer integer = new Integer(100);
        if(aLong>integer){
            System.out.println(123);
        }
    }
    @Test
    public void test2() {
        String name = "sg-6666667778666666777866666677786666667778666666777866666677786666";
        String finalName = "sg-" + name;
        System.out.println(finalName.length());
        System.out.println(name.length());
    }

    @Test
    public void test3(){
        String format = String.format("dhcp服务的ip[%s]应该在dhcp池范围内", "123");
        System.out.println(format);
    }

    @Test
    public void test4(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("13");
        strings.add("32");
        strings.add("2");
        String s = strings.stream().skip(RandomUtil.randomInt(0,strings.size())).findAny().get();
        System.out.println(s);


    }

    @Test
    public void test5(){
    }



}
