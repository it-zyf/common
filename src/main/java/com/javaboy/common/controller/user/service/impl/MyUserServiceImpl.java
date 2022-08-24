package com.javaboy.common.controller.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.controller.user.dao.mapper.MyUserMapper;
import com.javaboy.common.controller.user.dao.pojo.MyUser;
import com.javaboy.common.controller.user.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : zyf
 * @date : 2022/8/24 11:06
 */
@RequiredArgsConstructor
@Service
public class MyUserServiceImpl implements MyUserService {
    private final MyUserMapper myUserMapper;
    @Override
    public ResponseMsg<List<MyUser>> queryUser() {
        List<MyUser> myUsers = myUserMapper.selectList(new QueryWrapper<>());
        return new ResponseMsg<>(myUsers);
    }
}
