package com.javaboy.common.mapper;

import com.javaboy.common.entity.Hero;
import com.javaboy.common.entity.Infomation;
import com.javaboy.common.entity.Show;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yayu
 * @title: ThymelefMapper
 * @description:
 * @date 2021/1/8 15:14
 */
@Repository
public interface ThymelefMapper {
    List<Hero> index();

    List<Infomation> infomation();

    Show show(@Param("id") Integer id);

    List<Hero> getByid(@Param("id") Integer  id);
}
