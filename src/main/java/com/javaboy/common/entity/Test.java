package com.javaboy.common.entity;

import lombok.Data;

/**
 * @author zyf
 * @date 2022/12/22 15:16
 */
@Data
public class Test {

    private boolean a;

    private Boolean b;

    public Boolean getIsSuccess() {
        return b = b;
    }
}
