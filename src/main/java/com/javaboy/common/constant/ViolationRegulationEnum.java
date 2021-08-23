package com.javaboy.common.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * 违规行为
 *
 * @author: zyf
 * @create: 2021-08-19 15:28
 **/
public enum ViolationRegulationEnum {
    /**
     * 刷洞
     */
    BRUSHHOLE(1, "刷洞"),

    /**
     * 违规扫描
     */
    VIOLATIONSCAN(2, "违规扫描"),

    /**
     * 一洞多投
     */
    ONEHOLEMULTIPLESHOT(3, "一洞多投"),

    /**
     * 抄袭或转载
     */
    COPYORREPRINT(4, "抄袭或转载"),

    /**
     * 辱骂审核和工作人员
     */
    INSULTINGPEOPLE(5, "辱骂审核和工作人员"),

    /**
     * 社群内发表不良言论
     */
    BADSPEECH(6, "社群内发表不良言论");


    private Integer code;

    private String msg;


    ViolationRegulationEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public static String getMsg(Integer code) {
        if (code == null) {
            return null;
        }
        for (ViolationRegulationEnum statusEnum : values()) {
            if (statusEnum.getCode().compareTo(code) == 0) {
                return statusEnum.getMsg();
            }
        }
        return null;
    }

    public static Integer getCode(String msg) {
        if (StringUtils.isBlank(msg)) {
            return null;
        }
        for (ViolationRegulationEnum statusEnum : values()) {
            if (statusEnum.getMsg().equals(msg)) {
                return statusEnum.getCode();
            }
        }
        return null;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
