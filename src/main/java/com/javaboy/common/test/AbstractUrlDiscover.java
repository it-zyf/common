package com.javaboy.common.test;

import com.javaboy.common.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * @author zhaoqichao
 * @date 2023/7/3 16:38
 */
@Slf4j
public abstract class AbstractUrlDiscover implements UrlDiscover {
    //抽象类中实现公有逻辑处理.
    @Nullable
    @Override
    public Map<String, String> getUrlContentMap(String content) {
        return null;
    }

    @Nullable
    @Override
    public User getContent(String url) {
        return null;
    }


}
