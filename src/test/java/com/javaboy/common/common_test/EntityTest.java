package com.javaboy.common.common_test;

import com.alibaba.fastjson.JSON;
import com.javaboy.common.common_test.entity.OtherAttributeIn;
import org.junit.Test;

/**
 * @author zyf
 * @date 2023/7/28 17:18
 */

public class EntityTest {

    @Test
    public void test(){
        OtherAttributeIn otherAttributeIn = new OtherAttributeIn();

        otherAttributeIn.setKey("'中国'");
        otherAttributeIn.setValue("1321");
        System.out.println(JSON.toJSONString(otherAttributeIn));
    }
}
