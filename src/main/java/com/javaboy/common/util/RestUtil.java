package com.javaboy.common.util;


import com.javaboy.common.api.ResponseMsg;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * restTemplate 实现服务之间的远程掉用,此方法为阻塞试,效率比较低下
 * @author: zyf
 * @create: 2022-01-18 14:37
 **/
@Component
public class RestUtil {

    public ResponseMsg getSource(String url, String token, Object o){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization",token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        RequestEntity requestEntity = new RequestEntity(o, headers, HttpMethod.POST, URI.create(url));

        //④：发送请求(请求实体，返回值需要转换的类型)
        ResponseEntity<ResponseMsg> responseEntity = restTemplate.exchange(
                requestEntity,
                new ParameterizedTypeReference<ResponseMsg>() {
                });
        //⑤：获取结果
        return responseEntity.getBody();

    }

}
