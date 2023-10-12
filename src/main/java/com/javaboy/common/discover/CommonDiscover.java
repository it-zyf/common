package com.javaboy.common.discover;

import java.util.Objects;

/**
 * @author zyf
 * @date 2023/10/12 15:47
 */
public class CommonDiscover extends MyDiscoverAbstract{
    @Override
    public String getTitle(String title) {
        if (Objects.equals(title, "common")) {
            return "common 123";
        }
        return null;
    }
}
