package com.javaboy.common.controller.typeHader;

import com.javaboy.common.entity.HH;
import com.javaboy.common.service.TypeHaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yayu
 * @title: TypeHader
 * @description:
 * @date 2021/3/3 16:58
 */
@RequestMapping("/typehadle")
@RestController
public class TypeHaderController {
    @Autowired
    private TypeHaderService typeHaderService;

    @RequestMapping("/test")
    public String addHH() {
        typeHaderService.addHH();
        return "添加ok";
    }

    @RequestMapping("/sel")
    public List<HH> sel(){
        List<HH> sel = typeHaderService.sel();
        sel.forEach(li-> System.out.println(li));
        return sel;
    }
}
