package com.javaboy.common.json;

import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @author zyf
 * @date 2022/12/8 19:08
 */
public class Autil {
    public static boolean isIPv4(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        } else {
            return str.matches("^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])$") && Arrays.stream(str.split("\\.")).noneMatch((sp) -> {
                return sp.matches("0[\\d]+");
            });
        }
    }
}
