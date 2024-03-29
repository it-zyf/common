package com.javaboy.common.alltest;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import com.javaboy.common.entity.HH;
import com.javaboy.common.util.MyDateUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
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
    public void test1() {
        String we = "nmsl123";
        String s = Stream.of(we).skip(1).map(l -> "*").skip(we.length()).toString();
        System.out.println(s);

    }

    @Test
    public void test2() {
        List<String> strList = new ArrayList<String>();
        Collections.addAll(strList, "A-1-中-我", "A-1-国-没", "A-2-人-有", "A-2-民-钱", "B-1-银-肿", "B-2-行-么", "B-2-行-办");

        Map<String, Map<String, Map<String, List<String>>>> map = strList.stream().map(m -> {
            return m.split("-");
        }).collect(Collectors.groupingBy(k -> k[0], Collectors.groupingBy(k -> k[1], Collectors.groupingBy(k -> k[2], Collectors.collectingAndThen(Collectors.toList(), m -> m.stream().map(f -> f[3]).collect(Collectors.toList()))))));

        System.out.println(map);

    }

    @Test
    public void test3() {
        ArrayList<List<String>> lists = new ArrayList<>();
        String str = "11,12,13,1101,1102,1201,1301";
        String[] split = str.split(",");
        List<String> list = Arrays.asList(split);
        Map<String, List<String>> collect = list.stream().collect(Collectors.groupingBy(s -> s.substring(0, 2)));
        if(CollUtil.isNotEmpty(collect)){
            Collection<List<String>> values = collect.values();
            System.out.println(values);

        }
        System.out.println(collect);

//        List<String> collect = Arrays.stream(str.split(",")).map(String::valueOf).filter(l -> l.length() == 2).collect(Collectors.toList());
//        ArrayList<List<String>> lists = new ArrayList<>();
//        for (String s : collect) {
//            ArrayList<String> strings = new ArrayList<>();
//            String[] split = str.split(",");
//            for (int i = 0; i < split.length; i++) {
//                String substring = split[i].substring(0, 2);
//                if (s.equals(split[i].substring(0, 2))) {
//                    strings.add(split[i]);
//                }
//            }
//            lists.add(strings);
//        }
//        System.out.println(lists);
    }

    @Test
    public void test4() {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("age", "17");
        System.out.println(concurrentHashMap.get("age"));
        concurrentHashMap.remove("age");
        System.out.println(concurrentHashMap.get("age"));

    }


    @Test
    public void test5() {
        //当前时间
        Date date = DateUtil.date();
        //结束时间
        DateTime dateTime = DateUtil.endOfDay(date);

        System.out.println(date);
        System.out.println(dateTime);

        //相差时间
        long between = DateUtil.between(date, dateTime, DateUnit.SECOND);

        System.out.println(between);


    }

    @Test
    public void test6() {
        Integer a = 3;
        Integer b = 7;
        BigDecimal div = NumberUtil.div(a, b);

        String mul = NumberUtil.round(NumberUtil.mul(div, 100), 2) + "%";
        System.out.println(mul);
    }


    @Test
    public void test7() {
        Date date = new Date();
        DateTime dateTime1 = DateUtil.offsetDay(date, -6);
        String format = DateUtil.format(dateTime1, "yyyy-MM-dd");
//        System.out.println(format);
        String today = DateUtil.today();
//        System.out.println(today);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("2021-11-17");
        List<String> betweenDate = MyDateUtil.getBetweenDate(format, today);
        for (String s : betweenDate) {

            System.out.println(s);


        }
    }

    @Test
    public void test8() {
        String securityUser = IdUtil.simpleUUID();
        System.out.println(securityUser);
        String role = IdUtil.simpleUUID();
        System.out.println(role);
    }

    @Test
    public void test9() {
        BigDecimal al = new BigDecimal(1);
        for (int i = 0; i < 5; i++) {
            al = NumberUtil.add(al, i);
        }
        System.out.println(al);
    }


}
