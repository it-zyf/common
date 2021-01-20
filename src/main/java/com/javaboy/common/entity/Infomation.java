package com.javaboy.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author yayu
 * @title: Infomation
 * @description: TODO
 * @date 2021/1/6 16:49
 */
@Data
@Builder
public class Infomation {
    private String id;
    private String name;
    private String sex;
    private Integer age;
    private String photo;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date time;
}
