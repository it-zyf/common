package com.javaboy.common.mybatisjoin.service.impl;

import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.javaboy.common.completefuture.dao.entity.Account;
import com.javaboy.common.mybatisjoin.dao.mapper.JoinMapper;
import com.javaboy.common.mybatisjoin.dao.pojo.Emo;
import com.javaboy.common.mybatisjoin.service.MybatisJoinService;
import com.javaboy.common.mybatisjoin.service.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : zyf
 * @date : 2022/7/25 14:06
 */
@Service
@RequiredArgsConstructor
public class MybatisJoinServiceImpl implements MybatisJoinService {

    private final JoinMapper joinMapper;

    @Override
    public List<AccountDto> findAll(){

         Boolean flag=false;
        //关联查询
        return joinMapper.selectJoinList(AccountDto.class, new MPJLambdaWrapper<Account>()
                .selectAll(Account.class)
                .select(Emo::getEmo)
                .leftJoin(Emo.class,Emo::getId,Account::getId)
                .eq(flag,Emo::getId,"1")
        );
    }

}
