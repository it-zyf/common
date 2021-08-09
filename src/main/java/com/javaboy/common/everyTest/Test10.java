package com.javaboy.common.everyTest;

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
    public void test3(){
        String a="500";
        Integer b=500;
        System.out.println(ObjectUtil.equal(Integer.parseInt(a),500));
        System.out.println(ObjectUtils.nullSafeEquals(Integer.parseInt(a),500));
    }
}
