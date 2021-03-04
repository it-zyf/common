package com.javaboy.common.mapper;

import com.javaboy.common.entity.HH;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yayu
 * @title: TypeHaderMapper
 * @description: TODO
 * @date 2021/3/3 17:03
 */
@Mapper
public interface TypeHaderMapper {
    void addHH(HH hh);

    List<HH> sel();
}
