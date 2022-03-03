package com.javaboy.common.exception;

import java.io.Serializable;

/**
 *
 * @author yangjunguo
 * @date 21/6/9
 * 自定义的系统业务异常
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
