package com.javaboy.common.controller.easyexcel.dao.mapper;

import com.javaboy.common.controller.easyexcel.dao.pojo.ActResultLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : zyf
 * @date : 2022/9/28 16:04
 */
@Mapper
@Component
public interface ActResultLogMapper {
    Integer findActResultLogByCondations(int count);

    List<ActResultLog> findByPage100w();


}
