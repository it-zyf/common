package com.javaboy.common.controller.cacheable;

import com.javaboy.common.entity.BooleanTest;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyf
 * @date 2022/12/30 15:18
 */
@RestController
@RequestMapping("/boolean")
public class BooleanT {
    @Test
    public void test(){
        BooleanTest booleanTest = new BooleanTest();
        System.out.println(booleanTest.getB());
        System.out.println(booleanTest.getA());

    }
}
