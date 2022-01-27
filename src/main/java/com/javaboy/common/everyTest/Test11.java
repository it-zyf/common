package com.javaboy.common.everyTest;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.javaboy.common.constant.ViolationRegulationEnum;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 获取时间差
 *
 * @author: zyf
 * @create: 2021-08-20 11:22
 **/
public class Test11 {
    @Test
    public void test() {
        String dateStr1 = "2017-03-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);

        String dateStr2 = "2017-04-01 23:33:23";
        Date date2 = DateUtil.parse(dateStr2);

        //相差一个月，31天
        long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
        System.out.println(betweenDay);
    }

    @Test
    public void testStream() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        String collect = list.stream().map(str -> String.valueOf(ViolationRegulationEnum.getMsg(str))).collect(Collectors.joining(","));
        System.out.println(collect);
    }

    @Test
    public void test12(){
        double div = NumberUtil.div(2, 4,2);
        String s = String.valueOf(div * 100)+"%";
        System.out.println(s);

        System.out.println(DateUtil.today().replace("-","."));
    }

    @Test
    public void test13(){
        Double a =12.0;
        BigDecimal bigDecimal = new BigDecimal(a);
        BigDecimal add = bigDecimal.add(new BigDecimal(1));
        System.out.println(add);
    }

    @Test
    public void test14(){
        System.out.println(IdUtil.simpleUUID());
    }

    @Test
    public void test15(){
        String format="http:{}/alltesting/b/infoManage/role/list";
        System.out.println(StrUtil.format(format,"127.0.0.1:8081"));
    }

}
