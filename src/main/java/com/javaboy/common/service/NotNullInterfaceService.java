package com.javaboy.common.service;

import com.javaboy.common.entity.User;
import org.springframework.validation.annotation.Validated;

/**
 * @author zyf
 * @date 2023/9/24 14:00
 */
public interface NotNullInterfaceService {

    @Validated
    void notNullInterface(User user, String position);

}
