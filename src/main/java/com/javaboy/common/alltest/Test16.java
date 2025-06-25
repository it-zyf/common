package com.javaboy.common.alltest;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.javaboy.common.entity.Woman;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: zyf
 * @create: 2022-03-21 15:19
 **/
public class Test16 {
    @Test
    public void test() {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(7);
        list3.add(8);
        list3.add(9);

        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        StringBuilder sb = new StringBuilder();
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                sb.append(integer);
                sb.append(",");
            }
            sb.replace(sb.length() - 1, sb.length(), "");
            sb.append("/");
        }
        System.out.println(sb);
    }

    @Test
    public void test2() {
        List<String> s = new ArrayList<>();
//        s.add("123");
        System.out.println(s.size());
    }

    @Test
    public void test3() {
        Woman woman = Woman.builder().age("25").build();
        if(BeanUtil.isNotEmpty(woman)){
            System.out.println(1111);

        }
        System.out.println(woman.getAge());
    }

    @Test
    public void test4(){
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(7);
        list3.add(8);
        list3.add(9);
        list3.removeIf(integer -> integer == 7);
        for (Integer integer : list3) {

            System.out.println(integer);
        }
    }

    @Test
    public void test5(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("b");

    }

    @Test
    public void test6() throws MalformedURLException {
        java.lang.String a="[{\"value\":\"http://1232safa\",\"key\":\"1\"},{\"value\":\"http://1232safa323\",\"key\":\"1662028486609\"}]";
        java.lang.String replace = a.replace("[", "").replace("]", "");


        java.lang.String s = replace.split("}")[0];

        java.lang.String s3 = new StringBuilder(s).append("}").toString();

        Map map = JSON.parseObject(s3);

        URL value = new URL((java.lang.String) map.get("value"));
        java.lang.String host = value.getHost();
        System.out.println(host);

//
//        System.out.println(s);
//        java.lang.String s1 = s.split(",")[0];
//        java.lang.String s2 = s1.split(":")[1];
//        System.out.println(s2);

//        URL url = new URL("");
//        java.lang.String host = url.getHost();
//        System.out.println(host);
    }
}
