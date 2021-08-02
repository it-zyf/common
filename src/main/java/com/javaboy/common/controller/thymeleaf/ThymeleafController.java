package com.javaboy.common.controller.thymeleaf;

import com.github.pagehelper.PageInfo;
import com.javaboy.common.entity.Hero;
import com.javaboy.common.entity.Infomation;
import com.javaboy.common.entity.Show;
import com.javaboy.common.service.ThymelefService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yayu
 * @title: ThymelefController
 * @description: TODO
 * @date 2021/1/8 15:03
 */
@Controller
public class ThymeleafController {
    private static final Logger logger = LoggerFactory.getLogger(ThymeleafController.class);

    @Autowired
    private ThymelefService thymelefService;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        PageInfo<Hero> pageInfo = thymelefService.index(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        logger.info("查询成功1!");
        return "index";
    }

    @GetMapping("/xyy/information")
    public String information(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        PageInfo<Infomation> pageInfo = thymelefService.infomation(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "information";
    }


    @RequestMapping("/xyy/show")
    public String show(Model model, @RequestParam(defaultValue = "1") Integer id) {
        Show show = thymelefService.show(id);
        model.addAttribute("show",show);
        return "show";
    }


}
