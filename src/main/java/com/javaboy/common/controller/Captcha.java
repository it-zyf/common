package com.javaboy.common.controller;

import com.wf.captcha.*;
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
        //中文验证码
        ChineseCaptcha captcha = new ChineseCaptcha(130, 50, 6);
        //Gif验证码类
        GifCaptcha gifCaptcha = new GifCaptcha(130, 50, 6);
        //Gif中文验证码
        ChineseGifCaptcha chineseGifCaptcha=new ChineseGifCaptcha(130, 50, 6);
        //png格式验证码
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 50, 6);
        //算术验证码
        ArithmeticCaptcha arithmeticCaptcha = new ArithmeticCaptcha(130, 50, 3);
        System.out.println(arithmeticCaptcha.text());
        CaptchaUtil.out(arithmeticCaptcha,request, response);
    }
}
