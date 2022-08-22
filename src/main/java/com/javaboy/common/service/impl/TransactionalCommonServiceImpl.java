package com.javaboy.common.service.impl;

import com.javaboy.common.mapper.ModuleMapper;
import com.javaboy.common.service.TransactionalCommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : zyf
 * @date : 2022/8/22 11:11
 */
@Service
@RequiredArgsConstructor
public class TransactionalCommonServiceImpl implements TransactionalCommonService {
    private final ModuleMapper moduleMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void test() {
        moduleMapper.delModule(1302);
        System.out.println(0 / 0);
        moduleMapper.delModule(1401);

    }
}
