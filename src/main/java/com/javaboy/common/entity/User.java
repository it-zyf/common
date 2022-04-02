package com.javaboy.common.entity;

import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author yayu
 * @title: User
 * @description: TODO
 * @date 2021/2/2 14:09
 */
@Data
public class User implements Serializable {
    private String id;
    @NotNull(message = "名字不能为空")
    @Size(min = 2,message = "名字长度至少是两位")
    private String name;
    @NotNull(message = "年龄不能为空")
    @DecimalMin(value = "1",message = "年龄最少是一岁")
    @DecimalMax(value ="120",message = "年龄最大是一百二十岁")
    private Integer age;
    @NotNull(message = "邮件地址不能为空")
    @Email(message = "邮件格式不正确")
    private String email;
}
