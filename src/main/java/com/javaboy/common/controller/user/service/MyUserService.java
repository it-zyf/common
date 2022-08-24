package com.javaboy.common.controller.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.controller.user.dao.pojo.MyUser;

import java.util.List;

/**
 * @author : zyf
 * @date : 2022/8/24 11:05
 */
public interface MyUserService {
    /**
     * 前后端联调查询用户
     * @return
     */
    ResponseMsg<List<MyUser>> queryUser();
}
