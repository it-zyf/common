package com.javaboy.common.controller.redis.hotsort.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: zyf
 * @create: 2022-06-23 11:36
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("m_post")
public class MPost {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String title;

    private String userId;

    private Integer commentCount;

    private Integer viewCount;

    private Date created;
}
