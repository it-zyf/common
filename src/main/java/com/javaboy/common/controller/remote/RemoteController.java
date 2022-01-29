package com.javaboy.common.controller.remote;

import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.service.remote.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 一个远程调用的实现(优于httpclient restTemplate等)
 * @author: zyf
 * @create: 2022-01-29 10:58
 **/
@RestController
@RequestMapping("/remote")
public class RemoteController {
    @Autowired
    private RemoteService remoteService;

    @RequestMapping("/dict")
    public ResponseMsg remote(){
        return remoteService.getStaticDictInfo();
    }

    @PostMapping("/roleList")
    public ResponseMsg roleList(@RequestBody DtoRole dtoRole){
        return remoteService.roleList(dtoRole);
    }

}
