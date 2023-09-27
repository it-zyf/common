package com.javaboy.common.service.impl;

import com.javaboy.common.entity.User;
import com.javaboy.common.service.NotNullInterfaceService;
import org.springframework.stereotype.Service;

/**
 * @author zyf
 * @date 2023/9/24 14:01
 */
@Service
public class NotNullInterfaceServiceImpl implements NotNullInterfaceService {
    @Override
    public void notNullInterface( User user, String position) {

        System.out.println(position);

    }
}
