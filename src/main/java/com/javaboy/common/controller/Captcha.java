package com.javaboy.common.controller;

import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: zyf
 * @create: 2021-12-15 16:13
 **/
@Controller
@RequestMapping("/test")
public class Captcha {
    @GetMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ChineseCaptcha captcha = new ChineseCaptcha(130, 50, 6);
        System.out.println(captcha.text());
        CaptchaUtil.out(captcha,request, response);
    }
}
