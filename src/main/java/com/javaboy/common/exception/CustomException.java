package com.javaboy.common.exception;

import java.io.Serializable;


/**
 * @author v-zhangyafeng3
 */
public class CustomException extends Exception implements Serializable{

    private int code = 0;

    private String msg;

    public CustomException(int code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public CustomException(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
