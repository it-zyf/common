package com.javaboy.common.common_test.json;

import lombok.Data;

import java.util.List;

/**
 * @author zyf
 * @date 2023/6/20 10:56
 */
@Data
public class DeviceAuthEvent {

    private String uuid;

    private String operation;

    private String projectId;

    private String projectName;

    private String deviceId;

    private String deviceName;

    private List<Object> addresses;

    private AuthData authData;


    @Data
    public static class AuthData {
        private String vendorName;
        private String authCenterType;
        private String deviceType;
        private String version;
        private String defaultAuthModelName;
    }
}
