package com.javaboy.common.discover;

import java.util.Objects;

/**
 * @author zyf
 * @date 2023/10/12 15:48
 */
public class ChatDiscover extends MyDiscoverAbstract {
    @Override
    public String getTitle(String title) {
        if (Objects.equals(title, "chat")) {
            return "chat 123";
        }
        return null;
    }
}
