package com.javaboy.common.mapper;

import com.javaboy.common.controller.tree.ModuleFunctionMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yayu
 * @title: AddUserMapper
 * @description: TODO
 * @date 2020/9/1716:34
 */
@Repository
public interface TreeMapper {

    List<ModuleFunctionMenu> getAllList();

}
