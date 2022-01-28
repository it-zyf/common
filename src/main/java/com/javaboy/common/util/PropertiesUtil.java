package com.javaboy.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;


@Slf4j
public class PropertiesUtil {
    private static String webclientQbUrl;
    private static String webclientLgUrl;
    private static String webclientAuthor;

    static {
        ClassPathResource resource = new ClassPathResource("application.properties");
        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            webclientLgUrl = properties.getProperty("spring.webclient.lgurl");
            webclientAuthor=properties.getProperty("spring.webclient.author");
            webclientQbUrl = properties.getProperty("spring.webclient.qburl");
        } catch (IOException e) {
            log.error("application.properties属性文件读取异常" + e);
        }
        log.info("application.properties属性文件读取完成");
    }

    public static String getAuthor() {
        return webclientAuthor;
    }

    static String getTypeNum(int a) {
        switch (a){
            case 1:
                return webclientAuthor;
            case 2:
                return webclientLgUrl;
            case 3:
                return webclientQbUrl;
            default: break;
        }
        return null;
    }


}
