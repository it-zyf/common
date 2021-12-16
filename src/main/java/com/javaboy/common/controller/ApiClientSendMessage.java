package com.javaboy.common.controller;

import http.HttpInvoker;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zyf
 * @create: 2021-12-10 18:04
 **/
public class ApiClientSendMessage {
    private  HttpInvoker httpInvoker;
    //验证方式 apicode或appkey 默认apicode
    private String authoration = "apicode";

    //测试api地址
    private String testUrl = "https://api.yonyoucloud.com/apis/dst/mobilemessage/sendmessage";
    //请求方法类型
    private String methodType = "POST";
    //线程池参数文件路
    private static final String propertyUrl = "D:\\IDEA\\project\\common\\src\\main\\resources\\HttpClient.properties";

    public ApiClientSendMessage() throws Exception{
        httpInvoker = new HttpInvoker(propertyUrl);
    }

    public void test(){
        String msg="您的验证码为[1234]";
        String phone="15735653659";
        String apiCode="";
        String appKey="";
        String appSecret="";



        Map<String,Object> params = new HashMap<String,Object>();
        params.put("msg", msg);
        params.put("phone", "phone");
//        params.put("uid", "******");

        Map<String,String> header = new HashMap<String,String>();
        header.put("authoration", authoration);
        if(authoration.equals("apicode"))
        {//验证方式为apicode时需要添加apicode
            header.put("apicode","******");
        }else
        {//验证方式为appkey时需要添加appkey值和appsecret
            header.put("appkey","******");
            header.put("appsecret","******");
        }
        header.put("Content-Type", "******");

        String result = httpInvoker.invoker(testUrl, params, methodType, header);
        System.out.println(result);
    }

    //关闭线程
    public void destoy(){
        httpInvoker.destoy();
    }

    public static void main(String[] args){
        ApiClientSendMessage apiClient;
        try {
            apiClient = new ApiClientSendMessage();
            apiClient.test();
            apiClient.destoy();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
