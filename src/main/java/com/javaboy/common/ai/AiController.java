package com.javaboy.common.ai;

import cn.hutool.json.JSONUtil;
import com.zhipu.oapi.service.v4.model.ModelData;
import io.reactivex.Flowable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author zyf
 * @date 2025/2/14 17:36
 */
@RestController
@RequestMapping("/ai")
public class AiController {

    @Resource
    private AiManager aiManager;

    @GetMapping("/doStreamRequest")
    public void aiStreamRequest(){
        Flowable<ModelData> response = aiManager.doStreamRequest(null, "你好", null);
        // 订阅流式响应
        response.subscribe(
                // 处理每个数据块
                modelData -> {
                    System.out.println("收到数据块: " + modelData.toString());
                },
                // 处理错误
                throwable -> {
                    System.err.println("发生错误: " + throwable.getMessage());
                    throwable.printStackTrace();
                },
                // 处理完成
                () -> {
                    System.out.println("流式响应结束");
                }
        );
    }


    @GetMapping("/doRequest")
    public String aiDoRequest(String userMessage){
        try {
            // 调用 AI 接口并解析响应
            return Optional.ofNullable(aiManager.doRequest(null, userMessage, false, null))
                    .map(JSONUtil::parseObj)
                    .map(response -> response.getStr("message"))
                    .map(JSONUtil::parseObj)
                    .map(message -> message.getStr("content"))
                    .orElseThrow(() -> new RuntimeException("AI 响应解析失败: 响应无效"));
        } catch (Exception e) {
            System.err.println("获取 AI 响应失败: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("获取 AI 响应失败", e);
        }
    }

}
