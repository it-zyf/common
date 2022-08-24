package com.javaboy.common.controller.user.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaboy.common.controller.user.dao.pojo.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author : zyf
 * @date : 2022/8/24 11:07
 */
@Mapper
@Component
public interface MyUserMapper extends BaseMapper<MyUser> {
}
