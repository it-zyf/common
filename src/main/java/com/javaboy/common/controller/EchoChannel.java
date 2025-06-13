package com.javaboy.common.controller;

import cn.hutool.core.util.StrUtil;
import com.javaboy.common.websocket.DeleteDate;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/channel/echo")
@Slf4j
@Component
public class EchoChannel implements ApplicationContextAware {

    public static final ConcurrentHashMap<String, Session> SESSION_CONCURRENT_HASH_MAP = new ConcurrentHashMap<>();


    private Session session;


    // 全局静态变量，保存 ApplicationContext
    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        EchoChannel.applicationContext = applicationContext;
    }

    // 收到消息
    @OnMessage
    public void onMessage(String message) throws IOException, InterruptedException {
        
        log.info("[websocket] 收到消息：id={}，message={}", this.session.getId(), message);

        StringRedisTemplate stringRedisTemplate = EchoChannel.applicationContext.getBean(StringRedisTemplate.class);
        stringRedisTemplate.opsForValue().set("123",session.getId());

        //异步处理业务代码
        DeleteDate deleteDate = EchoChannel.applicationContext.getBean(DeleteDate.class);
        deleteDate.delete();

//        if (message.equalsIgnoreCase("bye")) {
//            // 由服务器主动关闭连接。状态码为 NORMAL_CLOSURE（正常关闭）。
//            this.session.close(new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, "Bye"));;
//            return;
//        }
//
//        this.session.getAsyncRemote().sendText("["+ Instant.now().toEpochMilli() +"] Hello " + message);
    }

    // 连接打开
    @OnOpen
    public void onOpen(Session session, EndpointConfig endpointConfig){
        // 保存 session 到对象
        this.session = session;

        SESSION_CONCURRENT_HASH_MAP.put(session.getId(),session);

        log.info("[websocket] 新的连接：id={}", this.session.getId());
    }

    // 连接关闭
    @OnClose
    public void onClose(CloseReason closeReason){
        String taskId = closeReason.getReasonPhrase();
        if (StrUtil.isNotBlank(taskId)){
            SESSION_CONCURRENT_HASH_MAP.remove(taskId);
        }
        log.info("[websocket] 连接断开：id={}，reason={}", this.session.getId(),closeReason);
    }

    // 连接异常
    @OnError
    public void onError(Throwable throwable) throws IOException {

        log.info("[websocket] 连接异常：id={}，throwable={}", this.session.getId(), throwable.getMessage());
        
        // 关闭连接。状态码为 UNEXPECTED_CONDITION（意料之外的异常）
        this.session.close(new CloseReason(CloseReason.CloseCodes.UNEXPECTED_CONDITION, throwable.getMessage()));
    }


    public static void sendMsg(String taskId){
        //回复删除
        try {
            StringRedisTemplate stringRedisTemplate = EchoChannel.applicationContext.getBean(StringRedisTemplate.class);
            String sessionId = stringRedisTemplate.opsForValue().get(taskId);
            Session session = EchoChannel.SESSION_CONCURRENT_HASH_MAP.get(sessionId);
            if (!session.isOpen()){
                return;
            }
            session.getAsyncRemote().sendText("删除成功！");
            session.close(new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, sessionId));
        } catch (Exception e) {
            log.error("回复消息异常！");

            throw new RuntimeException(e);
        }
    }


}