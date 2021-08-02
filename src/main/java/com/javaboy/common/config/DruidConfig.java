package com.javaboy.common.config;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * @author yayu
 * @title: DruidConfig
 * @description: TODO
 * @date 2021/3/5 11:10
 */
public class DruidConfig {
    public static void main(String[] args) throws Exception {
        String passWord="root";
        ConfigTools.main(new String[]{passWord});
    }
}
