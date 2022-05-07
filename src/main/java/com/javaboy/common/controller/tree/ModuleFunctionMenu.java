package com.javaboy.common.controller.tree;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author yayu
 * @title: ModuleFunctionMenu
 * @description:
 * @date 2021/6/17 10:07
 */
@Data

@EqualsAndHashCode(callSuper = false)
public class ModuleFunctionMenu {

    private Integer id;

    private Integer pid;

    private String name;

    private String remark;

    private Integer status;

    private String path;

    private List<ModuleFunctionMenu> pageList;

    private List<ModuleFunctionMenu> funcList;
}
