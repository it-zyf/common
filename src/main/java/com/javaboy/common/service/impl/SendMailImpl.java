package com.javaboy.common.service.impl;

import com.javaboy.common.service.SendMailService;
import com.javaboy.common.util.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yayu
 * @title: SendMailImpl
 * @description:
 * @date 2021/9/12 12:20
 */
@Service
@Slf4j
public class SendMailImpl implements SendMailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;


    @Override
    @Async
    public void sendMail() {
        long startTime = System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        list.add("14312121212@163.com");
        list.forEach(email -> taskExecutor.submit(() -> {
            try {
                System.out.println("线程-" + Thread.currentThread().getId() + "在执行写入");
                SimpleMailMessage message = new SimpleMailMessage();
                message.setSubject("这是一封测试邮件");
                message.setFrom("761769578@qq.com");
                message.setTo(email);
                message.setSentDate(new Date());
                message.setText("hello IM curry oligei");
                javaMailSender.send(message);
            } catch (MailException e) {
                log.error(email + "==={邮件发送失败}");
                e.printStackTrace();
            }
        }));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    @Override
    public String sendMail2() {
        List<String> list = new ArrayList<>();
        list.add("14312121212@163.com");
        String[] strings = list.toArray(new String[0]);
        try {
            MailUtil.commonMail("测试", strings, null, "securityUserCheckSuccess.ftl");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "ok";
    }
}
