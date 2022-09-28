package com.javaboy.common.controller.easyexcel.dao.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author : zyf
 * @date : 2022/9/28 16:00
 */
@Data
public class ActResultLog {
    private String onlineseqid;

    private String businessid;

    private String becifno;

    private String ivisresult;

    private String createdby;

    private Date createddate;

    private String updateby;

    private Date updateddate;

    private String risklevel;

}
