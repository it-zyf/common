package com.javaboy.common.service.remote;

import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.controller.remote.DtoRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zyf
 * @create: 2022-01-29 11:04
 **/
@Service
public class RemoteService {
    @Autowired
    HttpApi httpApi;

    public ResponseMsg getStaticDictInfo() {
        return httpApi.getStaticDictInfo();
    }

    public ResponseMsg roleList(DtoRole dtoRole) {

        return httpApi.roleList(dtoRole);
    }
}
