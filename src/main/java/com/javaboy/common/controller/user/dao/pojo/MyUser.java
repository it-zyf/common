package com.javaboy.common.controller.user.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : zyf
 * @date : 2022/8/24 11:07
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class MyUser {
   @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    @TableField("`desc`")
    private String desc;
}
