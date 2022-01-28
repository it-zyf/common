package com.javaboy.common.api;


import com.javaboy.common.constant.CodeConstant;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author v-zhangyafeng3
 * @date 21/5/26
 * 统一的响应对象
 */
@Setter
@Getter
public class ResponseMsg<T> implements Serializable {
    private int code;

    private String msg;

    private T data = null;

    public ResponseMsg(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResponseMsg(T data){
        this.code = CodeConstant.SUCCESS;
        this.msg = CodeConstant.SUCCESS_DESC;
        this.data = data;
    }

    public ResponseMsg(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    @SuppressWarnings("rawtypes")
    public static ResponseMsg success(){
        return new ResponseMsg<>(CodeConstant.SUCCESS, CodeConstant.SUCCESS_DESC);
    }
    @SuppressWarnings("rawtypes")
    public static ResponseMsg fail(){
        return new ResponseMsg<>(CodeConstant.FAIL, CodeConstant.FAIL_DESC);
    }
    @SuppressWarnings("rawtypes")
    public static ResponseMsg fail(int code, String msg){
        return new ResponseMsg<>(code, msg);
    }
}
