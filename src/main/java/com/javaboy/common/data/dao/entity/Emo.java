package com.javaboy.common.data.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zyf
 * @create: 2022-06-27 16:31
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("emo")
public class Emo {
    private String emo;
}
