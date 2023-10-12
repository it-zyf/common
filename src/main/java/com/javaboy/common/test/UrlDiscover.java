package com.javaboy.common.test;

import com.javaboy.common.entity.User;

import javax.annotation.Nullable;
import java.util.Map;

/**
 * @author zhaoqichao
 * @date 2023/7/3 16:34
 */
public interface UrlDiscover {

    @Nullable
    Map<String, String> getUrlContentMap(String content);
    @Nullable
    User getContent(String url);
    @Nullable
    String getTitle(String document);
    @Nullable
    String getDescription(String document);
    @Nullable
    String getImage(String url, String document);


}
