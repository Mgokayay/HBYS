package com.example.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TcknValidator implements ConstraintValidator<ValidTckn,Long> {
    @Override
    public void initialize(ValidTckn constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long tckn, ConstraintValidatorContext context) {
        if (tckn == null) {
            return false;
        }

        String tcknStr = tckn.toString();
        if (tcknStr.length() != 11) {
            return false;
        }

        if (tcknStr.chars().allMatch(c -> c == '0')) {
            return false;
        }


        return true;
    }
}
