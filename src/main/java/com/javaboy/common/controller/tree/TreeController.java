package com.javaboy.common.controller.tree;

import com.javaboy.common.service.impl.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zyf
 * @create: 2021-12-24 10:08
 **/
@RestController
@RequestMapping("/tree")
public class TreeController {
    @Autowired
    private TreeService treeService;

    @GetMapping("/getTree")
    public List<TreeNode<ModuleFunctionMenu>> getTree(){
       return treeService.getTree();
    }

    @GetMapping("/getTree2")
    public List<ModuleFunctionMenu> getTree2(){
        return treeService.getTree2();
    }
}
