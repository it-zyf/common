package com.javaboy.common.mapper;

import com.javaboy.common.entity.HH;
import com.javaboy.common.entity.Infomation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yayu
 * @title: AddUserMapper
 * @description: TODO
 * @date 2020/9/1716:34
 */
@Repository
public interface AddUserMapper {
    void addStudent(Infomation infomation);

    int hh(HH hh);

    List<Infomation> query();
}
