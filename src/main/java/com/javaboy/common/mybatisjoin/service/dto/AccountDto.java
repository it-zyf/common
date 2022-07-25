package com.javaboy.common.mybatisjoin.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : zyf
 * @date : 2022/7/25 14:20
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private Integer id;

    private String name;

    private String accountId;

    private String emo;
}
