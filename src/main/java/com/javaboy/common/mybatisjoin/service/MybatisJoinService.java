package com.javaboy.common.mybatisjoin.service;

import com.javaboy.common.mybatisjoin.service.dto.AccountDto;

import java.util.List;

/**
 * @author : zyf
 * @date : 2022/7/25 14:06
 */
public interface MybatisJoinService {
    /**
     * mybatisPlus联合查询
     * @return
     */
    List<AccountDto> findAll();

}
