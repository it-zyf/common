package com.javaboy.common.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author: zyf
 * @create: 2022-04-25 10:04
 **/
@Component
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "sendMsg")
    public void listen(String msg) {
        System.out.println(msg);
    }
}
