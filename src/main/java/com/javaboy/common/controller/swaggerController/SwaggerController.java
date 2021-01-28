package com.javaboy.common.controller.swaggerController;

import com.github.pagehelper.PageInfo;
import com.javaboy.common.entity.Hero;
import com.javaboy.common.service.ThymelefService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author yayu
 * @title: SwaggerController
 * @description: TODO
 * @date 2021/1/28 13:49
 */
@RestController
@Api(tags = "查询接口")
@RequestMapping("/query")
public class SwaggerController {
    @Autowired
    private ThymelefService thymelefService;


    @GetMapping("/hero/{id}")
    @ApiOperation("查询英雄接口")
    @ApiImplicitParam(name="id",value="英雄id",required=true,dataType="Integer")
    public PageInfo query_hero(@PathVariable("id") Integer id){
        PageInfo<Hero> pageInfo = thymelefService.getByid(id);
        return pageInfo;
    }

}
