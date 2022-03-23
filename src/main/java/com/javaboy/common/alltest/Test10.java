package com.javaboy.common.alltest;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.javaboy.common.entity.HH;
import org.junit.Test;
import org.springframework.util.ObjectUtils;

/**
 * @author: zyf
 * @create: 2021-08-05 16:35
 **/
public class Test10 {
    @Test
    public void test() {
        HH he = null;
        HH hh = new HH();
//        boolean notNull = ObjectUtil.isNotNull(hh);
//        System.out.println(hh.toString());
//        System.out.println(notNull);
        //用来判断对象是否为空
        boolean empty = BeanUtil.isEmpty(hh);
        System.out.println(empty);
    }

    @Test
    public void test2() {

        Integer a = 900;
        Integer b = 900;
        System.out.println(a.equals(b));
    }


    @Test
    public void test3() {
        String a = "500";
        Integer b = 500;
        System.out.println(ObjectUtil.equal(Integer.parseInt(a), 500));
        System.out.println(ObjectUtils.nullSafeEquals(Integer.parseInt(a), 500));
    }

    @Test
    public void test4() {
        String ip = "127.01.01,1012123";
        String[] split = ip.split(",");
        if (split.length >= 2) {
            System.out.println(split[1]);
        }
    }

    @Test
    public void test5(){
        String phone="15735653659";
        String phoneNumber = phone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
        System.out.println(phoneNumber);

        String email="15735653659@qq.com";
        String resultEmail = email.replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4");
        System.out.println(resultEmail);
    }



}
