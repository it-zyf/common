package com.javaboy.common.data.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaboy.common.data.dao.entity.Emo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: zyf
 * @create: 2022-06-27 16:32
 **/
@Mapper
@Repository
public interface ExpressionMapper extends BaseMapper<Emo> {
}
