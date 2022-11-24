package com.javaboy.common.util.tree;

/**
 * @author zyf
 * @date 2022/11/24 16:41
 */

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 树结构工具类
 * 文档：https://gitee.com/wslxm/xijia-plus/wikis/%E5%B7%A5%E5%85%B7%E7%B1%BB/%E6%A0%91%E7%BB%93%E6%9E%84%E5%B7%A5%E5%85%B7%20TreeUtil%20
 *
 * <P>
 *     ts 中的对象需继承 BaseTree 父对象类, 示例 extends BaseTree<MediaCategoryVO,String>
 *     如果你的数据结构是不是 id / pid 进行关联，那么在你的类中需要重BaseTree中的 id / pid 的 set / get 方法读取和设置你的关联key值
 *
 *     如: 你的关联是： code  pcode
 *     public String getId() {  return this.code;  }
 *     public String getPid() { return this.pCode;    }
 *     public void setId(String id) {  this.code = id; }
 *     public void setPid(String pid) {  this.pCode = pid;  }
 *
 *     如果你想返回值不使用 parentNode, 在自己的类中定义存放数据的对象重写 get set 方法即可（同id/pid）
 *     如果你想返回值不使用 children, 在自己的类中定义存放数据的对象重写 get set 方法即可（同id/pid）
 * </P>
 * @author 15735
 */
public class TreeUtil {


    /**
     * list 转 tree 结构（转子节点）
     * @author wangsong
     * @param ts  列表数据（有关联关系的列表数据）(查询所有数据需构建顶级数据放入ts中)
     * @param pid  父id （S表示Id可以为任意数据类型）
     * @date 2022/11/21 0021 10:01
     * @return java.util.List<T>  返回传入的 id 当前节点的数据
     * @version 1.0.0
     */
    @SneakyThrows
    public static <T extends BaseTree, S> T nextTree(List<T> ts, S pid) {
        if (ts == null || ts.size() == 0 || pid == null) {
            return null;
        }
        // 检查pid节点是否存在
        boolean isExist = false;
        T resT = null;
        for (T t : ts) {
            if (t.getId().equals(pid)) {
                resT = t;
                isExist = true;
                break;
            }
        }
        // pid节点不存在则创建
        if (!isExist) {
            Class<? extends BaseTree> aClass = ts.get(0).getClass();
            T t2 = (T) aClass.newInstance();
            t2.setId(pid);
            t2.setPid((S) "-1");
            ts.add(t2);
            resT = t2;
        }

        // 处理数据
        Map<Object, List<T>> treeGroupMap = ts.stream().collect(Collectors.groupingBy(BaseTree::getPid));
        for (T t : ts) {
            t.setChildren(treeGroupMap.get(t.getId()));
        }
        return resT;
    }


    /**
     * 获取所有子节点的Ids （不包括传入的pid）
     * @author wangsong
     * @param ts 所有节点的列表数据
     * @param pid 父节点值
     * @date 2022/11/21 0021 13:15
     * @return java.util.List<S> 返回所有下级ids，不包括传入的pid
     * @version 1.0.0
     */
    public static <T extends BaseTree, S> List<S> nextIds(List<T> ts, S pid) {
        if (ts == null || ts.size() == 0 || pid == null) {
            return null;
        }
        // 父级数据
        List<S> nextIds = new ArrayList<>();
        for (T t : ts) {
            // 当前类
            if (pid.equals(t.getPid())) {
                nextIds.add((S) t.getId());
                // 递归获取
                nextIds.addAll(nextIds(ts, (S) t.getId()));
            }
        }
        return nextIds;
    }


    /**
     * 获取指定节点的父节点数据 tree 结构（转父节点）
     *
     * @author wangsong
     * @param ts  列表数据（有关联关系的列表数据）
     * @param id  当前数据的 id （S表示Id可以为任意数据类型）
     * @date 2022/11/21 0021 10:01
     * @return java.util.List<T>  返回传入的 id 当前节点的数据
     * @version 1.0.0
     */
    public static <T extends BaseTree, S> T fatherTree(List<T> ts, S id) {
        if (ts == null || ts.size() == 0 || id == null) {
            return null;
        }
        // 转map
        Map<Object, T> treeMap = ts.stream().collect(Collectors.toMap(BaseTree::getId, p -> p));
        for (T t : ts) {
            t.setParentNode(treeMap.get(t.getPid()));
        }
        return treeMap.get(id);
    }


    /**
     * 获取父节点ids (包括传入的id)
     *
     * @author wangsong
     * @param ts  列表数据（有关联关系的列表数据）
     * @param id  当前数据的 id （S表示Id可以为任意数据类型）
     * @date 2022/11/21 0021 10:01
     * @return java.util.List<S>  返回ids, 包括传入的id （返回数据list 按层级顺序排序，1级-> 2级-> 3级 -> .....）
     * @version 1.0.0
     */
    public static <T extends BaseTree, S> List<S> fatherIds(List<T> ts, S id) {
        if (ts == null || ts.size() == 0 || id == null) {
            return null;
        }
        // 转map
        Map<Object, T> treeMap = ts.stream().collect(Collectors.toMap(BaseTree::getId, p -> p));
        // 找父级
        LinkedList<S> ptIds = new LinkedList<>();
        while (true) {
            T t = treeMap.get(id);
            if (t == null) {
                break;
            }
            ptIds.addFirst(id);
            id = (S) t.getPid();
        }
        return ptIds;
    }
}