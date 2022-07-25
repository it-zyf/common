package com.javaboy.common.mybatisjoin.dao.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

/**
 * @author : zyf
 * @date : 2022/7/25 14:16
 */
@TableName
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Emo {
    @Id
    private Integer id;

    private String emo;
}
