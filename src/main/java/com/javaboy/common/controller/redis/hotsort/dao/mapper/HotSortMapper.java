package com.javaboy.common.controller.redis.hotsort.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaboy.common.controller.redis.hotsort.dao.entity.MPost;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


/**
 * @author: zyf
 * @create: 2022-06-23 11:42
 **/
@Component
@Mapper
public interface HotSortMapper extends BaseMapper<MPost> {
}
