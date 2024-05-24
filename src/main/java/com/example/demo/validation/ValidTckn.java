package com.example.demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TcknValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTckn {
    String message() default "Geçersiz TC Kimlik Numarası";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
