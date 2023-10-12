package com.javaboy.common.test;

import org.jetbrains.annotations.Nullable;

/**
 * @author zyf
 * @date 2023/10/12 16:21
 */
public class QqUrlDiscover extends AbstractUrlDiscover{
    //具体,举列:qq业务实现
    @Nullable
    @Override
    public String getTitle(String document) {
        return null;
    }

    @Nullable
    @Override
    public String getDescription(String document) {
        return null;
    }

    @Nullable
    @Override
    public String getImage(String url, String document) {
        return null;
    }
}
