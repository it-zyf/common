package com.javaboy.common.controller.restriction;

import com.javaboy.common.validata.AllowValue;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyf
 * @date 2023/2/16 18:24
 */
@RestController
@RequestMapping("/restriction")
@Validated
public class RestrictionController {
    @GetMapping("/getName")
    public String restriction(@AllowValue(value = "张三,李四",required = true,message = "输入值不合法") String name) {
        return name;
    }
}
