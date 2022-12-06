package com.javaboy.common.annotations.valiata;


import com.javaboy.common.annotations.CollectionPattern;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collection;


/**
 * @author zyf
 */
public class CollectionPatternImpl implements ConstraintValidator<CollectionPattern, Collection<String>> {
    private CollectionPattern constraint;

    @Override
    public void initialize(CollectionPattern constraint) {
        this.constraint = constraint;
    }

    @Override
    public boolean isValid(Collection<String> obj, ConstraintValidatorContext context) {
        if (!CollectionUtils.isEmpty(obj)) {
            return obj.stream().allMatch(element -> element.matches(constraint.regexp()));
        }
        return true;
    }
}
