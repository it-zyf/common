package com.javaboy.common.service.impl;

import com.javaboy.common.mapper.CommonUserMapper;
import com.javaboy.common.service.CommonUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author: zyf
 * @create: 2022-03-18 10:38
 **/
@Service
@RequiredArgsConstructor
public class CommonUserServiceImpl implements CommonUserService {

    private final CommonUserMapper commonUserMapper;
    @Override
    public void delUser(String userId) {
        commonUserMapper.delUser(userId);
        commonUserMapper.delUser("268f10804357b56482ee26f9d6c477b1");
    }
}
