package com.javaboy.common.service.impl;

import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.constant.CodeConstant;
import com.javaboy.common.entity.CommonUser;
import com.javaboy.common.mapper.UserMapper;
import com.javaboy.common.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author: zyf
 * @create: 2022-03-10 14:41
 **/
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    @Cacheable(cacheNames = "userInfo", key = "#userId")
    public ResponseMsg<CommonUser> getUserInfo(Integer userId) {
      CommonUser commonUser= userMapper.getUserInfo(userId);
      return new ResponseMsg<>(CodeConstant.SUCCESS, CodeConstant.SUCCESS_DESC, commonUser);
    }
}
