package com.javaboy.common.util;

import cn.hutool.core.util.StrUtil;

/**
 * @author: zyf
 * @create: 2021-12-02 16:11
 **/
public class Encryption {
    public static String replaceEmail(String email) {
        if(StrUtil.isEmpty(email)){
            return null;
        }
        return email.replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4");
    }

}
