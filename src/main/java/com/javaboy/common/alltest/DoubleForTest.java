package com.javaboy.common.alltest;

import cn.hutool.core.text.CharSequenceUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: zyf
 * @create: 2022-07-12 14:25
 **/
public class DoubleForTest {
    /**
     * 元素个数:50000
     * DoubleFor运行时间:18642
     */
    @Test
    public void test(){
        List<String> list1 = Lists.newArrayList();
        for (int i = 0; i < 100000; i++) {
            list1.add(String.valueOf(i));
        }

        List<String> list2 = Lists.newArrayList();
        for (int i = 50000; i < 150000; i++) {
            list2.add(String.valueOf(i));
        }
        List<String> overlapList = new ArrayList<>();

        long start = System.currentTimeMillis();
        for (String str1 : list1) {
            for (String str2 : list2) {
                if(str1.equals(str2)){
                    overlapList.add(str1);
                    break;
                }
            }
        }
        System.out.println("元素个数:"+overlapList.size());
        System.out.println("DoubleFor运行时间:"+(System.currentTimeMillis()-start));

    }

    /**
     * 元素个数:50000
     * DoubleFor运行时间:73
     */
    @Test
    public void test2(){
        List<String> list1 = Lists.newArrayList();
        for (int i = 0; i < 100000; i++) {
            list1.add(String.valueOf(i));
        }

        List<String> list2 = Lists.newArrayList();
        for (int i = 50000; i < 150000; i++) {
            list2.add(String.valueOf(i));
        }
        List<String> overlapList = new ArrayList<>();

        long start = System.currentTimeMillis();
        HashMap<String, String> map = Maps.newHashMap();
        for (String str2 : list2) {
            map.put(str2,str2);
        }
        for (String str1 : list1) {
            String value = map.get(str1);
            if(CharSequenceUtil.isNotBlank(value)){
                overlapList.add(value);
            }
        }
        System.out.println("元素个数:"+overlapList.size());
        System.out.println("DoubleFor运行时间:"+(System.currentTimeMillis()-start));

    }

}
