package com.javaboy.common.completefuture.service;

import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.completefuture.dao.entity.Account;

import java.util.List;

/**
 * @author: zyf
 * @create: 2022-07-04 17:31
 **/
public interface AccountService {

    /**
     * 查询账户
     * @param accountIdList
     * @return
     */
    ResponseMsg<List<Account>> list(List<Integer> accountIdList);


    /**
     * 异步编排,整个结果返回
     * @return
     */
    List<String> queryAllList();

}
