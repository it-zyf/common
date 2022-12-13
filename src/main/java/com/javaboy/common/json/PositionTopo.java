package com.javaboy.common.json;


import io.netty.util.internal.StringUtil;
import lombok.Data;

/**
 * 节点位置
 *
 * @author peng
 * @date 2018/4/4
 */
@Data
public class PositionTopo extends CommonConfig {
    private String id;
    private String TopoId;
    @Deprecated
    private String networkid;

    private String networkId;

    private String name;

    private String type;

    private Integer status;

    private String x;

    private String y;

    private Integer width;

    private Integer height;
    @Deprecated
    private Integer parentlevel;
    @Deprecated
    private Integer topolevel;
    @Deprecated
    private Integer nextlevel;

    private Integer parentLevel;

    private Integer topoLevel;

    private Integer nextLevel;

    private String nodeImage;

    private String vmType;

    private String property;
    @Deprecated
    private String groupid;

    private String groupId;

    private String clusterId;

    private Long party;

    private String physicalId;

    private String physicalType;

    private String description;

    private String district;

    private String internalKey;

    private String groupType;

    private String country;
    private String longitude;
    private String latitude;
    private String altitude;
    private String province;
    private String city;
    private String street;
    /**
     * 是否是靶标
      */
    private Boolean isTarget;
    /**
     * 是否是靶心
      */
    private Boolean isBullseye;
    private String rangeId;
    private String rangeName;
    private String targetInfoId;

    public String getNetworkId() {
        return networkId = StringUtil.isNullOrEmpty(networkId)?networkid:networkId;
    }

    public Integer getParentLevel() {
        return parentLevel = null == parentLevel?parentlevel:parentLevel;
    }

    public Integer getTopoLevel() {
        return topoLevel = null == topoLevel?topolevel:topoLevel;
    }

    public Integer getNextLevel() {
        return nextLevel = null == nextLevel?nextlevel:nextLevel;
    }

    public String getGroupId() {
        return groupId = StringUtil.isNullOrEmpty(groupId)?groupid:groupId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public void setParentLevel(Integer parentLevel) {
        this.parentLevel = parentLevel;
    }

    public void setTopoLevel(Integer topoLevel) {
        this.topoLevel = topoLevel;
    }

    public void setNextLevel(Integer nextLevel) {
        this.nextLevel = nextLevel;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
