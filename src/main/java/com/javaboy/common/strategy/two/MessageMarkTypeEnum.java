package com.javaboy.common.strategy.two;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Description: 消息标记类型
 * Author: <a href="https://github.com/zongzibinbin">abin</a>
 * Date: 2023-03-19
 */
@AllArgsConstructor
@Getter
public enum MessageMarkTypeEnum {
    COMMON(1, "通用支付", 10),
    WECHAT(2, "微信支付", 5),
    QQ(3, "QQ支付", 5),
    ;

    private final Integer type;
    private final String desc;
    private final Integer riseNum;//需要多少个标记升级

    private static Map<Integer, MessageMarkTypeEnum> cache;

    static {
        cache = Arrays.stream(MessageMarkTypeEnum.values()).collect(Collectors.toMap(MessageMarkTypeEnum::getType, Function.identity()));
    }

    public static MessageMarkTypeEnum of(Integer type) {
        return cache.get(type);
    }
}
