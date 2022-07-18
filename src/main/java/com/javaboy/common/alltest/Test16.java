package com.javaboy.common.alltest;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javaboy.common.entity.Woman;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        s.add("123");
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
        Page<T> tPage = new Page<>();
    }

}
