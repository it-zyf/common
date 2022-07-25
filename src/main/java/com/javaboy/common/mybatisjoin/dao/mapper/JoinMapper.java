package com.javaboy.common.mybatisjoin.dao.mapper;

import com.github.yulichang.base.mapper.MPJJoinMapper;
import com.javaboy.common.completefuture.dao.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author : zyf
 * @date : 2022/7/25 14:11
 */
@Mapper
@Component
public interface JoinMapper extends MPJJoinMapper<Account> {

}
