package com.javaboy.common.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zyf
 * @create: 2022-04-24 18:02
 **/
@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class SimpleTest {

    private final KafkaTemplate<Object, Object> kafkaTemplate;


    @GetMapping("/send/{msg}")
    public String simpleTest(@PathVariable("msg") String msg)  {
        kafkaTemplate.send("sendMsg", msg);
        return "send ok";
    }

}
