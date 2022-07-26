package com.javaboy.common.mybatisjoin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.completefuture.dao.entity.Account;
import com.javaboy.common.mybatisjoin.service.dto.AccountDto;

import java.util.List;

/**
 * @author : zyf
 * @date : 2022/7/25 14:06
 */
public interface MybatisJoinService extends IService<Account> {
    /**
     * mybatisPlus联合查询
     * @return
     */
    List<AccountDto> findAll();

    /**
     * mybatis plus 批量修改
     * @param list
     * @return
     */
    ResponseMsg updateBatch(List<Account> list);
}
