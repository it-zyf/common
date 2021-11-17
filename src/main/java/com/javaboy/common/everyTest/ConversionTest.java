package com.javaboy.common.everyTest;

import com.javaboy.common.util.ReadUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zyf
 * @create: 2021-11-04 15:25
 **/
public class ConversionTest {
    @Test
    public void run() {
        List<String> modelList = new ArrayList<>();
        int begin = 17;
        int end = 17;
        for (int i = begin; i <= end; i++) {
            modelList.add(String.valueOf(i));
        }
        myConversion(modelList);
    }


    public void myConversion(List<String> list) {
        List<String> date = getDate();
        StringBuilder allSb = new StringBuilder();
        for (String model : list) {
            StringBuilder sb = new StringBuilder();
            for (String id : date) {
                if (model.equals(id.substring(0, 2))) {
                    sb.append(id + ",");
                }
            }
            sb.replace(sb.length() - 1, sb.length(), "/");
            System.out.println(sb);
            allSb.append(sb);
        }
        System.out.println(allSb.toString());
    }


    public List<String> getDate() {
        try {
            return ReadUtil.getFileContext("D:\\123.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
