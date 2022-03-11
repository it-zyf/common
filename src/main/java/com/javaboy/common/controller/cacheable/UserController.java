package com.javaboy.common.controller.cacheable;

import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.entity.CommonUser;
import com.javaboy.common.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zyf
 * @create: 2022-03-10 14:36
 **/
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/info")
    public ResponseMsg<CommonUser> getUserInfo(Integer userId) {
        return userService.getUserInfo(userId);
    }
}
