package com.javaboy.common.completefuture.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zyf
 * @create: 2022-07-04 17:28
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Integer id;

    private String name;

    private String accountId;

}
