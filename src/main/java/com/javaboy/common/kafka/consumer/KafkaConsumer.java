package com.javaboy.common.kafka.consumer;

import cn.hutool.json.JSONUtil;
import com.javaboy.common.kafka.entity.CanalMessage;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: zyf
 * @create: 2022-04-25 10:04
 **/
//@Component
@Slf4j
@SuppressWarnings("rawtypes")
public class KafkaConsumer {

    private static final String DELETE="delete";

    @ApiOperation("kafka消费")
    @KafkaListener(topics = "sendMsg",groupId = "1")
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println(record.value());
    }

    @ApiOperation("kafka 消费canal监听数据")
    @KafkaListener(topics = "canal_kafka",groupId = "2")
    public void listenDataChange(String message){
        //将message转换为CanalMessage
        CanalMessage canalMessage = JSONUtil.toBean(message, CanalMessage.class);
        String tableName = canalMessage.getTable();
        log.info("Canal 监听 {} 发生变化；明细：{}", tableName, message);
        // 业务逻辑自己完善...............
        if(DELETE.equalsIgnoreCase(canalMessage.getType())){
            List data = canalMessage.getData();
            Optional.ofNullable(data).orElseGet(ArrayList::new).forEach(
                    System.out::println
            );
            System.out.println("有人删除表中数据");
        }
    }

}
