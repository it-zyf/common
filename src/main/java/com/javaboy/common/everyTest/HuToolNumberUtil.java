package com.javaboy.common.everyTest;

import cn.hutool.core.util.NumberUtil;
import org.junit.Test;

/**
 * @author: zyf
 * @create: 2021-12-27 15:17
 **/
public class HuToolNumberUtil {

    @Test
    public void test(){
        Double a=312321.233;
        Double b=312321.333;
        double add = NumberUtil.add(a, b);

        int compare = NumberUtil.compare(a, b);
        System.out.println(compare);

    }
}
