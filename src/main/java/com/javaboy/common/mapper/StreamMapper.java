package com.javaboy.common.mapper;

import com.javaboy.common.entity.Infomation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.stereotype.Repository;

/**
 * @author yayu
 * @title: StreamMapper
 * @description: TODO
 * @date 2021/2/18 15:39
 */
@Repository
public interface StreamMapper {
    @Select("select * from infomation limit #{limit}")
    Cursor<Infomation> query(@Param("limit") int limit);
}
