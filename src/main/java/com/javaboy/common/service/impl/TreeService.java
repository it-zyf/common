package com.javaboy.common.service.impl;

import com.javaboy.common.controller.tree.ConvertTree;
import com.javaboy.common.controller.tree.ModuleFunctionMenu;
import com.javaboy.common.controller.tree.TreeNode;
import com.javaboy.common.mapper.TreeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: zyf
 * @create: 2021-12-24 10:09
 **/
@Service
public class TreeService {

    @Autowired
    private TreeMapper treeMapper;

    public List<TreeNode<ModuleFunctionMenu>> getTree() {
        //获取集合
        List<ModuleFunctionMenu> list = treeMapper.getAllList();
        //创建工具类
        ConvertTree<ModuleFunctionMenu>  convertTree= new ConvertTree<>();
        //生成森林
        List<TreeNode<ModuleFunctionMenu>> forest = convertTree.getForest(list, "id", "pid");
        return forest;

    }


    public List<ModuleFunctionMenu> getTree2(){
        //获取集合
        List<ModuleFunctionMenu> list = treeMapper.getAllList();
        List<ModuleFunctionMenu> modelList = Optional.ofNullable(list).orElse(new ArrayList<>()).stream()
                .filter(model -> model.getPid() == 0)
                .collect(Collectors.toList());
        Optional.ofNullable(modelList).orElse(new ArrayList<>()).forEach(model -> model.setPageList(getChild(model.getId(), list)));

        return modelList;
    }

    private List<ModuleFunctionMenu> getChild(Integer id, List<ModuleFunctionMenu> allList) {
        List<ModuleFunctionMenu> pageList = Optional.ofNullable(allList).orElse(new ArrayList<>()).stream()
                .filter(model -> model.getPid().equals(id))
                .collect(Collectors.toList());
        Optional.ofNullable(pageList).orElse(new ArrayList<>()).forEach(page -> page.setFuncList(getChild(page.getId(), allList)));
        return pageList;
    }



}
