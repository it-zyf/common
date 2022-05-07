package com.javaboy.common.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @author yayu
 * @title: User3
 * @description:
 * @date 2021/6/10 10:36
 */
@Data
public class User3 implements java.io.Serializable{
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "年龄")
    private Integer age;
}
