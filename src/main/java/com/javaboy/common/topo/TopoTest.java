package com.javaboy.common.topo;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zyf
 * @date 2023/4/27 11:16
 */
public class TopoTest {

    @Test
    public void test() {
        HashSet<NodeLinkRelation> container = new HashSet<>();
        List<NodeLinkRelation> list = new ArrayList<>();

// 添加一些NodeLinkRelation对象到列表中
        list.add(new NodeLinkRelation("1", "2"));
        list.add(new NodeLinkRelation("2", "3"));
        list.add(new NodeLinkRelation("3", "4"));
        list.add(new NodeLinkRelation("4", "5"));
        list.add(new NodeLinkRelation("5", "6"));
        list.add(new NodeLinkRelation("4", "7"));

        String id = "4";
        TopoTest topoTest = new TopoTest();
        topoTest.serarch(container, list, id);

        System.out.println(JSON.toJSON(container));

    }


    private void serarch(HashSet<NodeLinkRelation> container, List<NodeLinkRelation> list, String id) {
        for (NodeLinkRelation nodeLinkRelation : list) {
            String target = nodeLinkRelation.getTarget();
            String currentId = nodeLinkRelation.getId();
            if (StringUtils.equals(id, nodeLinkRelation.getId())) {
                boolean add = container.add(nodeLinkRelation);
                if (!add) {
                    continue;
                }
                serarch(container, list, target);
            }
        }
    }

    @Test
    public void test2(){
        List<RangeEntity> list =new ArrayList<>();
        list.add(new RangeEntity("123","1"));
        list.add(new RangeEntity("123","2"));

        List<Map<String, String>> collect = list.stream()
                .filter(r -> StrUtil.isNotBlank(r.getRangeProjectId()))
                .collect(Collectors.groupingBy(
                        RangeEntity::getRangeId
                ))
                .entrySet()
                .stream()
                .flatMap(e -> e.getValue()
                        .stream()
                        .map(r -> {
                            Map<String, String> map = new HashMap<>();
                            map.put(e.getKey(), r.getRangeProjectId());
                            return map;
                        }))
                .collect(Collectors.toList());
        System.out.println(JSON.toJSON(collect));
    }

    @Test
    public void test3(){
        ArrayList<Object> objects = new ArrayList<>();
        System.out.println(objects.get(0));
    }


    @Test
    public void test4(){
        ArrayList<String> objects = Lists.newArrayList();
        objects.add("a");
        objects.add("a");

        System.out.println(objects.size());
        boolean flag = objects.stream().allMatch(d -> Objects.equals(d,"a") || Objects.equals(d, "b"));
        System.out.println(flag);

        int i = Integer.parseInt("-99");
        System.out.println(i);
    }


}
