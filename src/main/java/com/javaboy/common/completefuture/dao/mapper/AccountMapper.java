package com.javaboy.common.completefuture.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaboy.common.completefuture.dao.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author: zyf
 * @create: 2022-07-04 17:39
 **/
@Component
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
