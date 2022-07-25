package com.javaboy.common.mybatisjoin.dao.mapper;

import com.github.yulichang.base.mapper.MPJJoinMapper;
import com.javaboy.common.mybatisjoin.dao.pojo.Emo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author : zyf
 * @date : 2022/7/25 14:18
 */
@Mapper
@Component
public interface EmoMapper extends MPJJoinMapper<Emo> {
}
