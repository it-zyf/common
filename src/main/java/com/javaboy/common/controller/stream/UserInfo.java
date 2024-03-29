package com.javaboy.common.controller.stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zyf
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private String userId;

    private String name;

    private Integer age;

    private List<String> hobby;
}
