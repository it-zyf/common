package com.javaboy.common.controller.stream;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;

import java.util.Date;

/**
 * @author: zyf
 * @create: 2022-04-15 18:04
 **/
public class StreamTest {


    @org.junit.Test
    public void test() {
    String fileName="我是中国人.zip";
        System.out.println("/" +
                "dev" +
                "/" +
                DateUtil.format(new Date(), "yyyyMMdd") +
                "/" +
                IdUtil.simpleUUID() +
                fileName.substring(fileName.lastIndexOf(".")));
    }
}
