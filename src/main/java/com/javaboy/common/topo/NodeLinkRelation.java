package com.javaboy.common.topo;

/**
 * @author zyf
 * @date 2023/4/27 11:16
 */
public class NodeLinkRelation {
    private String id;
    private String target;

    public NodeLinkRelation(String id, String target) {
        this.id = id;
        this.target = target;
    }

    public String getId() {
        return id;
    }

    public String getTarget() {
        return target;
    }
}
