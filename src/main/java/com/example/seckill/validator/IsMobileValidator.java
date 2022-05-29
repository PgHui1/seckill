package com.example.seckill.validator;

import com.example.seckill.utils.ValidatorUtil;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsMobileValidator implements ConstraintValidator<IsMobile,String> {
    private boolean required = true;

    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.isRequired();
    }

    @Override
    public boolean isValid(String mobbile, ConstraintValidatorContext constraintValidatorContext) {
        return ValidatorUtil.isMobile(mobbile);
    }
}
