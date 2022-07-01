package com.javaboy.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zyf
 * @create: 2022-06-30 17:24
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Woman {

    private String height;

    private String weight;

    private String age;

    private String hobby;
}
