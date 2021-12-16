package com.javaboy.common.controller;

import com.javaboy.common.util.SendMailUtil;

/**
 * @author: zyf
 * @create: 2021-12-13 11:02
 **/
public class SendMailTest {
    public static void main(String[] args) {
        SendMailUtil.getRequest("【众测平台】您的验证码为1234","",null);
    }
}
