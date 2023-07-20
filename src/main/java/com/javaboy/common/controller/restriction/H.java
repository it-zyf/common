package com.javaboy.common.controller.restriction;

import com.javaboy.common.validata.AllowValue;
import lombok.Data;

/**
 * @author zyf
 * @date 2023/2/23 13:43
 */
@Data
public class H {

    @AllowValue(value = "1,2,3",message = "参数错误")
    private String age;
}
