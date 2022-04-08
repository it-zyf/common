package com.javaboy.common.service.remote;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.controller.remote.DtoRole;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @author: zyf
 * @create: 2022-01-29 11:00
 **/
@RetrofitClient(baseUrl = "http://localhost:8081")
@SuppressWarnings("rawtypes")
public interface HttpApi {
    @GET("/alltesting/b/common/dict")
    ResponseMsg getStaticDictInfo();

    @POST("/alltesting/b/infoManage/role/list")
    ResponseMsg roleList(@Body DtoRole dtoRole);
}
