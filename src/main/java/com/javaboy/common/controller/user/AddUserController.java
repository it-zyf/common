package com.javaboy.common.controller.user;

import com.github.pagehelper.PageInfo;
import com.javaboy.common.service.AddUserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yayu
 * @title: AddUserConTroller
 * @description:
 * @date 2020/9/1716:28
 */
@RestController
@RequestMapping("/add")
@RequiredArgsConstructor
public class AddUserController {
    private static final Logger logger = LoggerFactory.getLogger(AddUserController.class);

    private final AddUserService addUserService;

    @RequestMapping("/user")
    public Map add() {
        return addUserService.addUser();
    }

    /**
     * mybatis 插入回显自增id
     *
     * @return
     */
    @RequestMapping("/hh")
    public int hh() {
        return addUserService.hh();
    }

    /**
     * pageHelper 使用
     * @param pageNum
     * @param pageSize
     * @return
     */

    @RequestMapping("/page")
    public PageInfo pageInfo(int pageNum, int pageSize) {
        return addUserService.query(pageNum,pageSize);
    }


}
