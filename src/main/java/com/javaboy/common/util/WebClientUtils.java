package com.javaboy.common.util;

import com.google.common.net.HttpHeaders;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.apache.commons.codec.binary.Base64;

import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;
import java.util.Map;


public class WebClientUtils {

    public WebClientUtils() throws SSLException {
    }

    private String Base64Str(){
        byte[] basicAuth = Base64.encodeBase64(PropertiesUtil.getAuthor().getBytes());
        String authStringEnc = new String(basicAuth);
        return authStringEnc;
    }

    /**
     *创建webClient
     */
    SslContext sslContext = SslContextBuilder
            .forClient()
            .trustManager(InsecureTrustManagerFactory.INSTANCE)
            .build();
    HttpClient httpClient = HttpClient.create().secure(t-> t.sslContext(sslContext));


    /**
     * @param url
     * @param token
     * @param platform  传平台
     * @return
     */
    public String sendByGet(String url,String token,int platform){
        WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(PropertiesUtil.getTypeNum(platform))
                .defaultHeader(HttpHeaders.AUTHORIZATION, token == null ?  "Basic "+this.Base64Str(): token)
                .build();
        Mono<String> resp =webClient.get()
                .uri(url)
                .header(HttpHeaders.CONTENT_TYPE,"application/json")
                .retrieve()
                .bodyToMono(String.class);
        return resp.block();
    }

    public String sendByGetByPage(String url,Integer pageSize,Integer size ,String token,int platform){
        WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(PropertiesUtil.getTypeNum(platform))
                .defaultHeader(HttpHeaders.AUTHORIZATION, token == null ?  "Basic "+this.Base64Str(): token)
                .build();
        Mono<String> resp =webClient.get()
                .uri(url+"?page="+pageSize+"&"+"size="+size)
                .header(HttpHeaders.CONTENT_TYPE,"application/json")
                .retrieve()
                .bodyToMono(String.class);
        return resp.block();
    }

    /**
     * 按莫个字段降序排列
     * @param url
     * @param pageSize
     * @param size
     * @param param
     * @return
     */
    public String getSortListByPage(String url,Integer pageSize,Integer size,String param ,String token,int platform){
        WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(PropertiesUtil.getTypeNum(platform))
                .defaultHeader(HttpHeaders.AUTHORIZATION, token == null ?  "Basic "+this.Base64Str(): token)
                .build();
        Mono<String> resp =webClient.get()
                .uri(url+"?page="+pageSize+"&"+"size="+size+"&"+"sort="+param+",desc")
                .header(HttpHeaders.CONTENT_TYPE,"application/json")
                .retrieve()
                .bodyToMono(String.class);
        return resp.block();
    }

    public String getSortListByPage2(String url,Integer pageSize,Integer size,String param ,String token,int platform){
        WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(PropertiesUtil.getTypeNum(platform))
                .defaultHeader(HttpHeaders.AUTHORIZATION, token == null ?  "Basic "+this.Base64Str(): token)
                .build();
        Mono<String> resp =webClient.get()
                .uri(url+"?number="+pageSize+"&"+"size="+size+"&"+"sort="+param)
                .header(HttpHeaders.CONTENT_TYPE,"application/json")
                .retrieve()
                .bodyToMono(String.class);
        return resp.block();
    }
    /**
     * get 方法  含参数
     * @param url
     * @param uriVariables
     * @return
     */
    public String sendByParam(String url ,Map<String, Object> uriVariables ,String token,int platform){
        WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(PropertiesUtil.getTypeNum(platform))
                .defaultHeader(HttpHeaders.AUTHORIZATION, token == null ?  "Basic "+this.Base64Str(): token)
                .build();
        Mono<String> resp =  webClient.get()
                .uri(url ,uriVariables)
                .header(HttpHeaders.CONTENT_TYPE,"application/json")
                .retrieve()
                .bodyToMono(String.class);
        return resp.block();
    }


    public String sendByParamAndPage(String url ,Integer pageSize,Integer size,Map<String, Object> uriVariables ,String token,int platform){
        WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(PropertiesUtil.getTypeNum(platform))
                .defaultHeader(HttpHeaders.AUTHORIZATION, token == null ?  "Basic "+this.Base64Str(): token)
                .build();
        Mono<String> resp =  webClient.get()
                .uri(url+"?page="+pageSize+"&"+"size="+size ,uriVariables)
                .header(HttpHeaders.CONTENT_TYPE,"application/json")
                .retrieve()
                .bodyToMono(String.class);
        return resp.block();
    }

    /**
     * post 方法json
     * @param url
     * @param object
     * @return
     */
    public String sendJsonByPost(String url, Object object ,String token,int platform){
        WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(PropertiesUtil.getTypeNum(platform))
                .defaultHeader(HttpHeaders.AUTHORIZATION, token == null ?  "Basic "+this.Base64Str(): token)
                .build();
        Mono<String> resp = webClient.post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(object),Object.class)
                .retrieve().bodyToMono(String.class);
        return resp.block();
    }

    /**
     * post 方法json
     * @param url
     * @param object
     * @return
     */
    public String sendJsonByPost2(String url ,Map<String, Object> uriVariables, Object object ,String token,int platform){
        WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(PropertiesUtil.getTypeNum(platform))
                .defaultHeader(HttpHeaders.AUTHORIZATION, token == null ?  "Basic "+this.Base64Str(): token)
                .build();
        Mono<String> resp = webClient.post()
                .uri(url,uriVariables)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(object),Object.class)
                .retrieve().bodyToMono(String.class);
        return resp.block();
    }


    /**
     * 删除
     * @param url
     * @param uriVariables
     * @return
     */
    public String sendDelet(String url,Map<String, Object> uriVariables ,String token,int platform){
        WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(PropertiesUtil.getTypeNum(platform))
                .defaultHeader(HttpHeaders.AUTHORIZATION, token == null ?  "Basic "+this.Base64Str(): token)
                .build();
        Mono<String> resp =webClient.delete()
                .uri(url, uriVariables)
                .retrieve().bodyToMono(String.class);
        return resp.block();
    }

    public String sendPut(String url,Object object ,String token,int platform){
        WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(PropertiesUtil.getTypeNum(platform))
                .defaultHeader(HttpHeaders.AUTHORIZATION, token == null ?  "Basic "+this.Base64Str(): token)
                .build();
        Mono<String> resp =webClient.put()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(object),Object.class)
                .retrieve().bodyToMono(String.class);
        return resp.block();
    }

    public String sendPut2(String url,Map<String, Object> uriVariables,Object object ,String token,int platform){
        WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(PropertiesUtil.getTypeNum(platform))
                .defaultHeader(HttpHeaders.AUTHORIZATION, token == null ?  "Basic "+this.Base64Str(): token)
                .build();
        Mono<String> resp =webClient.put()
                .uri(url,uriVariables)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(object),Object.class)
                .retrieve().bodyToMono(String.class);
        return resp.block();
    }

}
