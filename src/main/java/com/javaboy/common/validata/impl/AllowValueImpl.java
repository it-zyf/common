package com.javaboy.common.validata.impl;


import cn.hutool.core.util.StrUtil;
import com.javaboy.common.validata.AllowValue;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author zyf
 */
public class AllowValueImpl implements ConstraintValidator<AllowValue, Object> {
    private String value;
    private boolean required;

    @Override
    public void initialize(AllowValue constraint) {
        this.value = constraint.value();
        this.required = constraint.required();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        if (null != obj) {
            if (StrUtil.isNotBlank(value)) {
                String[] split = value.split(",");
                if (split.length > 0) {
                    for (String s : split) {
                        if (obj instanceof String){
                            if (s.equals(obj)) {
                                return true;
                            }
                        }else if (obj instanceof Integer){
                            if ((obj).equals(Integer.parseInt(s))){
                                return true;
                            }
                        }
                    }
                }
            }
        } else {
            return required?false:true;
        }
        return false;
    }
}
