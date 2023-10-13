package com.javaboy.common.groups.controller;

import com.alibaba.fastjson.JSON;
import com.javaboy.common.groups.Groups;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author zyf
 * @date 2023/10/13 9:44
 */
@RestController
@RequestMapping("groups")
@Slf4j
public class GroupsController {

    /**
     * @Validated(AddGroupsInterface.class) 对实体中多有分组内的字段校验
     * @param groups
     */
    @PostMapping("/add")
    public void addGroups(@Validated(Groups.AddGroupsInterface.class) @RequestBody Groups groups) {

        System.out.println(JSON.toJSONString(groups));
    }

    @PostMapping("/update")
    public void updateGroups(@Valid @RequestBody Groups groups) {
        System.out.println(JSON.toJSONString(groups));
    }


}
