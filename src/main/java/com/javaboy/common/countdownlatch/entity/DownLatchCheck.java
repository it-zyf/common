package com.javaboy.common.countdownlatch.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author zyf
 * @date 2023/1/21 11:11
 */
@Data
@Builder
public class DownLatchCheck {
    /**
     * 错误信息
     */
    private String msg;

    /**
     * 错误内容
     */
    private Object data;
}
