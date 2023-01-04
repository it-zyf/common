package com.javaboy.common.entity;

import lombok.Data;

/**
 * @author zyf
 * @date 2022/12/30 15:17
 */
@Data
public class BooleanTest {
    private boolean a;

    private Boolean b =Boolean.FALSE;

    public boolean getA() {
        return a = a;
    }
}
