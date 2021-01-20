package com.javaboy.common.service;


import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @author yayu
 * @title: AddUserService
 * @description: TODO
 * @date 2020/9/1716:32
 */
public interface AddUserService {
    Map addUser();

    int hh();

    PageInfo query(int pageNum, int pageSize);
}
