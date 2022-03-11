package com.javaboy.common.service;

import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.entity.CommonUser;

/**
 * @author: zyf
 * @create: 2022-03-10 14:40
 **/
public interface UserService {
    /**
     * 获取用户信息
     * @param userId
     * @return
     */
     ResponseMsg<CommonUser> getUserInfo(Integer userId);
}
