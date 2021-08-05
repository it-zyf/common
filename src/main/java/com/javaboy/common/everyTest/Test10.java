package com.javaboy.common.everyTest;

import cn.hutool.core.bean.BeanUtil;
import com.javaboy.common.entity.HH;
import org.junit.Test;

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
}
