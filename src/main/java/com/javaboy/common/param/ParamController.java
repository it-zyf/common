package com.javaboy.common.param;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyf
 * @date 2022/12/6 14:05
 */
@RestController
@RequestMapping("/param")
public class ParamController {
    @PostMapping("/getParam")
    public String getParam(@RequestBody MyParam myParam){
        return myParam.getUserName().get(0);
    }
}
