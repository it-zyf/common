package com.javaboy.common.util.tree;

/**
 * @author zyf
 * @date 2022/11/24 16:38
 */
import lombok.Data;

import java.util.List;

@Data
public class BaseTree<T, S> {

    /**
     * id
     */
    private S id;
    /**
     * 关联父节点值
     */
    private S pid;

    /**
     * 下级tree数据 （处理数据后存放）
     */
    private List<T> children;

    /**
     * 父级tree数据 （处理数据后存放）
     */
    private T parentNode;

}