package com.javaboy.common.controller.validated;

import com.javaboy.common.entity.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yayu
 * @title: ValidatedController
 * @description: TODO springboot中的字段校验 前端的数据校验是为了用户体验,后端接口的校验才是为了数据完整性.
 * @date 2021/2/2 14:14
 */
@RestController
@RequestMapping("/vd")
public class ValidatedController {
    @RequestMapping("/addUser")
    public Map<String, Object> addUser(@RequestBody @Validated User user, BindingResult result) {
        if (null != result && result.hasErrors()) {
            return new HashMap<String, Object>() {{
                put("code", "403");
                put("msg", result.getFieldError().getDefaultMessage());
            }};
        }
        System.out.println(user);
        return new HashMap<String, Object>() {{
            put("code", 200);
            put("msg", "添加成功");
        }};
    }
}
