package com.javaboy.common.controller.mail;

import com.javaboy.common.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yayu
 * @title: TestMailController
 * @description: TODO
 * @date 2021/9/12 12:19
 */
@RestController
@RequestMapping("/send")
public class TestMailController {
    @Autowired
    private SendMailService sendMailService;

    @RequestMapping("/mail")
    public String sendMail(){
        sendMailService.sendMail();
        return "ok!";
    }
}
