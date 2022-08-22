package com.javaboy.common.service.impl;

import com.javaboy.common.mapper.CommonUserMapper;
import com.javaboy.common.mapper.ModuleMapper;
import com.javaboy.common.service.CommonUserService;
import com.javaboy.common.service.MyTransactionService;
import com.javaboy.common.service.TransactionalCommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 不同数据源:
 * 1.一个方法有Transactional注解的情况下用@DS多数据源会起冲突导致数据源切换失败.(Transactional会绑定一个数据源)
 * 2.一个Transactional的方法下,在dao接口上开启一个新的事务,Transactional方法的报错回滚不会影响dao接口的执行
 * 3.一个Transactional的方法下,在service接口开启一个新事务,service接口内报错,事务都会回滚
 * 4.一个Transactional的方法下,在service接口开启一个新事务,Transactional方法的报错回滚不会影响service接口的执行
 * 同一数据源:
 * 1.一个方法有Transactional注解的情况下,调用一个service接口上有Transactional注解,service接口报错全部回滚
 * 2.一个方法有Transactional注解的情况下,调用一个service接口上有Transactional注解,该方法报错,全部回滚
 *
 * @author: zyf
 * @create: 2022-03-18 10:02
 **/
@Service
@RequiredArgsConstructor
public class MyTransactionServiceImpl implements MyTransactionService {

    private final ModuleMapper moduleMapper;

    private final CommonUserMapper commonUserMapper;

    private final CommonUserService commonUserService;

    private final TransactionalCommonService transactionalCommonService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public String transactionTest() {
        moduleMapper.delModule(12);
        commonUserService.delUser("25a2d12ad6de03fc0b396e46c13fd71d");
        System.out.println(0 / 0);
        moduleMapper.delModule(13);
        return "ok!";
    }

    @Override
    public String transactionTest2() {
        moduleMapper.delModule(1301);
        // 该事务不生效
//        test();
        transactionalCommonService.test();
        return "ok!";
    }

    @Transactional(rollbackFor = Exception.class)
    public void test() {
        moduleMapper.delModule(1301);
        System.out.println(0 / 0);
        moduleMapper.delModule(1302);

    }
}
