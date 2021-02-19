package com.javaboy.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.yedaxia.apidocs.Ignore;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Infomation
 */
@Data
@Builder
public class Infomation {
    private String id; //id
    private String name; //姓名
    private String sex; //性别
    private Integer age; //年龄
    private String photo; //照片
    @JsonFormat(pattern="yyyy-M M-dd HH:mm:ss",timezone = "GMT+8")
    private Date time; //时间
}
