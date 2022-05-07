package com.javaboy.common.alltest;

import cn.hutool.core.util.IdUtil;
import org.junit.Test;

/**
 * @author : zyf
 * @date : 2022/5/5 18:02
 */
public class BatchUuidTest {
    @Test
    public void batchUuid(){
        for (int i = 0; i < 10; i++) {
            System.out.println(IdUtil.simpleUUID());
        }
    }
}
