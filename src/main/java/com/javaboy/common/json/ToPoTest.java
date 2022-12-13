package com.javaboy.common.json;

import cn.hutool.core.util.NumberUtil;
import org.junit.Test;

/**
 * @author zyf
 * @date 2022/12/8 14:26
 */

public class ToPoTest {

    @Test
    public void test(){
        String target="10.1.1.10-40";

        if (target.contains("-")) {
            String[] split = target.split("-");
            if (split.length == 2) {
                if (Autil.isIPv4(split[0]) && NumberUtil.isNumber(split[1])) {
                    int start = Integer.parseInt(split[0].substring(split[0].lastIndexOf(".") + 1));
                    int end = Integer.parseInt(split[1]);
                    if (start < end && end <= 20) {
                        return;
                    }
                }
            }
            System.out.println(111);
        }
    }
}
