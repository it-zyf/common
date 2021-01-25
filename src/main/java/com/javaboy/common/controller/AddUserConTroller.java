package com.javaboy.common.controller;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.javaboy.common.service.AddUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author yayu
 * @title: AddUserConTroller
 * @description: TODO
 * @date 2020/9/1716:28
 */
@RestController
@RequestMapping("/add")
public class AddUserConTroller {
    @Autowired
    private AddUserService addUserService;

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
