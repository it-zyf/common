package com.javaboy.common.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author: zyf
 * @create: 2022-03-18 10:38
 **/
@Transactional(rollbackFor = Exception.class)
public interface CommonUserService {
    /**
     * 删除用户id
     * @param userId
     */
    void delUser(String userId);
}
