package com.javaboy.common.exception;

import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.constant.CodeConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 最基础的全局异常处理
 * @author: zyf
 * @create: 2022-03-03 10:32
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ResponseMsg handleValidException(Exception e) {
        log.error("参数校验失败:" + e.getMessage());
        return ResponseMsg.fail(CodeConstant.FAIL, e.getMessage());

    }

}
