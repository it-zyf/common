package com.javaboy.common.exception;

import com.google.common.collect.Lists;
import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.constant.CodeConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.Objects;

/**
 * @author: zyf
 * @create: 2022-03-03 10:17
 **/
//@RestControllerAdvice
public class ExceptionHandle {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseMsg handleException(Exception e){
        if(e instanceof CustomException) {
            CustomException ex = (CustomException)e;
            log.error("自定义业务异常：msg：" + ex.getMessage() , e);
            return ResponseMsg.fail(ex.getCode(), ex.getMessage());
        }else if(e instanceof ClassCastException) {
            e.printStackTrace();
            ClassCastException ex = (ClassCastException)e;
            log.error("参数校验异常：msg：" + ex.getLocalizedMessage());
            return ResponseMsg.fail(CodeConstant.FAIL,
                    CodeConstant.PARAM_ERROR + "：类型转换异常！");
        }else if(e instanceof MethodArgumentTypeMismatchException) {
            e.printStackTrace();
            MethodArgumentTypeMismatchException ex = (MethodArgumentTypeMismatchException)e;
            log.error("参数校验异常：msg：" + ex.getLocalizedMessage());
            return ResponseMsg.fail(CodeConstant.FAIL,
                    CodeConstant.PARAM_ERROR + "：方法参数类型不匹配！");
        }else if(e instanceof MethodArgumentNotValidException) {
            e.printStackTrace();
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException)e;
            log.error("参数校验异常：msg：" + Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage());
            return ResponseMsg.fail(CodeConstant.FAIL,
                    CodeConstant.PARAM_ERROR + "：方法参数不合法！");
        }else if(e instanceof NumberFormatException) {
            e.printStackTrace();
            NumberFormatException ex = (NumberFormatException)e;
            log.error("参数校验异常：msg：" + ex.getLocalizedMessage());
            return ResponseMsg.fail(CodeConstant.FAIL,
                    CodeConstant.PARAM_ERROR + "：数字格式化异常！");
        }else{
            e.printStackTrace();
            log.error("系统异常：msg：" + e.getMessage(), e);
            return ResponseMsg.fail(CodeConstant.FAIL, e.getMessage());
        }
    }


    /**
     * 参数校验异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    @ResponseBody
    public ResponseMsg handleValidException(MethodArgumentNotValidException e) {
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        List<String> errors = Lists.newArrayList();
        for (ObjectError bojo : allErrors) {
            errors.add(bojo.getDefaultMessage());
        }
        log.error("参数校验失败:" + e.getParameter().getMethod() + errors);
        return ResponseMsg.fail(CodeConstant.FAIL, CodeConstant.PARAM_ERROR + errors);

    }





}
