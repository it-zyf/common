package com.javaboy.common.everyTest;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;

/**
 * @author: zyf
 * @create: 2021-12-17 16:16
 **/
public class HuToolStr {
    @Test
    public void test() {
        String code = "123";
        String template = "【众测平台】您正在注册众测平台账号，验证码{}，有效期10分钟，请勿向他人泄露。如非本人操作，可忽略本消息。";
        String str = StrUtil.format(template, code);
        System.out.println(str);
    }


}
