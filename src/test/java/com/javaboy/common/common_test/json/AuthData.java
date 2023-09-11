package com.javaboy.common.common_test.json;

import lombok.Data;

@Data
    public  class AuthData {
        private String vendorName;
        private String authCenterType;
        private String deviceType;
        private String version;
        private String defaultAuthModelName;
    }