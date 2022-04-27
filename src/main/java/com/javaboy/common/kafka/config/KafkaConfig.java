package com.javaboy.common.kafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import javax.annotation.Resource;
import java.time.Duration;

/**
 * @author: zyf
 * @create: 2022-04-27 10:37
 **/
@Configuration
public class KafkaConfig {

    @Resource
    private KafkaSendResultHandler kafkaSendResultHandler;

    @Resource
    private ProducerFactory<Object, Object> producerFactory;

    @Bean
        KafkaTemplate<Object,Object> kafkaTemplate() {
        KafkaTemplate<Object, Object> kafkaTemplate = new KafkaTemplate<>(producerFactory);
        kafkaTemplate.setProducerListener(kafkaSendResultHandler);
        kafkaTemplate.setCloseTimeout(Duration.ofSeconds(10));
        return kafkaTemplate;
    }

}
