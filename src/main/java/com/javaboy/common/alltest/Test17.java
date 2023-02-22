package com.javaboy.common.alltest;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.RandomUtil;
import com.google.common.collect.Lists;
import com.javaboy.common.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        String s = strings.stream().skip(RandomUtil.randomInt(0,strings.size())).findAny().orElseThrow(()->new RuntimeException("没有合适的数据"));
        System.out.println(s);


    }
    @Test
    public void test5(){
        User user = new User();
        user.setAge(4);
        User user1 = new User();
        user1.setAge(8);
        User user2 = new User();
        user2.setAge(8);
        List<User> users = Lists.newArrayList(user, user1, user2);
        User user3 = users.stream().reduce((a, b) -> a.setAge((a.getAge() + b.getAge()) / 2)).orElseThrow(()->new RuntimeException("数据异常"));
        System.out.println(user3);

    }

    @Test
    public void  test6(){
        List<Integer> deployedStatus = new ArrayList<>(getDeployedStatus());
        deployedStatus.add(8);
        deployedStatus.remove(3);
        System.out.println(deployedStatus.size());
    }


    public static List<Integer> getDeployedStatus() {
        return Arrays.asList(1, 2, 3, 4, 6, 7);
    }



}
