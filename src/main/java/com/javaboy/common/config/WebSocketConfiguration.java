package com.javaboy.common.config;

import com.javaboy.common.controller.EchoChannel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author zyf
 * @date 2024/10/17 16:00
 */
@Configuration
public class WebSocketConfiguration {
    @Bean
    public ServerEndpointExporter serverEndpointExporter (){

        ServerEndpointExporter exporter = new ServerEndpointExporter();

        // 手动注册 WebSocket 端点
        exporter.setAnnotatedEndpointClasses(EchoChannel.class);

        return exporter;
    }
}
