package com.javaboy.common.mapper;

import com.javaboy.common.entity.CommonUser;

/**
 * @author: zyf
 * @create: 2022-03-10 14:42
 **/
public interface UserMapper {
    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    CommonUser getUserInfo(Integer userId);
}
