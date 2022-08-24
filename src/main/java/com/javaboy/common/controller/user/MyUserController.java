package com.javaboy.common.controller.user;

import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.controller.user.dao.pojo.MyUser;
import com.javaboy.common.controller.user.service.MyUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : zyf
 * @date : 2022/8/24 11:03
 */
@RequiredArgsConstructor
@RequestMapping("myUser")
@RestController
@Api(tags = "前后端联调测试查询接口")
public class MyUserController {
    private final MyUserService myUserService;
    
    @GetMapping("/query")
    @ApiOperation("前后端联调查询用户列表")
    public ResponseMsg<List<MyUser>> queryUser(){
        return myUserService.queryUser();
    }
}
