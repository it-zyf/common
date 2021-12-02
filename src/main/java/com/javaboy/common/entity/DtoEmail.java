package com.javaboy.common.entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author: zyf
 * @create: 2021-12-02 16:18
 **/
@Data
public class DtoEmail {
    @NotBlank(message = "邮件地址不能为空")
    @Email(message = "邮件格式不正确")
    private String aaa;
}
