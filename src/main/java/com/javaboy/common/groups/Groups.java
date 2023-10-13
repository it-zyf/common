package com.javaboy.common.groups;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zyf
 * @date 2023/10/13 9:41
 */
@Data
public class Groups {

    @NotBlank(message = "CIDR不能为空",groups = {UpdateGroupsInterface.class,AddGroupsInterface.class})
    @NotBlank(message = "CIDR不能为空")
    private String id;
    @NotBlank(message = "CIDR不能为空",groups = {UpdateGroupsInterface.class,AddGroupsInterface.class})
    @NotBlank(message = "CIDR不能为空")
    private String cidr;
    @NotBlank(message = "gatewayIp不能为空")
    private String gatewayIp;

    public interface AddGroupsInterface {
    }

    public interface UpdateGroupsInterface {
    }
}
