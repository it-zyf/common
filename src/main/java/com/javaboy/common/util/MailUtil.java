package com.javaboy.common.util;

import com.javaboy.common.CommonApplication;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.io.StringWriter;
import java.util.Date;
import java.util.Map;

/**
 * @author: zyf
 * @create: 2021-08-23 14:31
 **/
@Component
public class MailUtil {


    private static JavaMailSender javaMailSender;

    @Resource
    private JavaMailSender mailSender;

    @PostConstruct
    public void init() {
        javaMailSender = mailSender;
    }


    public static void commonMail(String subject, String[] strings, Map map, String temp) throws Exception {
        //配置邮箱信息
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("761769578@qq.com");
        //构建 Freemarker 的基本配置
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
        // 配置模板位置
        ClassLoader loader = CommonApplication.class.getClassLoader();
        configuration.setClassLoaderForTemplateLoading(loader, "template");
        //设置主题
        helper.setSubject(subject);
        //加载模板
        Template template = configuration.getTemplate(temp);
        //发送邮件
        helper.setTo(strings);
        helper.setSentDate(new Date());
        //模板渲染，渲染的结果将被保存到 out 中 ，将out 中的 html 字符串发送即可
        StringWriter out = new StringWriter();
        template.process(map, out);
        helper.setText(out.toString(), true);
        javaMailSender.send(mimeMessage);
    }


}
