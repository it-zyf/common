package com.javaboy.common.controller.restriction;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyf
 * @date 2023/2/23 13:42
 */
@RestController
@RequestMapping("/vaid/test")
public class Test {

    @GetMapping("/hh")
    public String restriction(@Validated H h) {
        return h.getAge();
    }

}
