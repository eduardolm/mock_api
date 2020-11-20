package com.guiabolso.mock.validator.constraint;

import com.guiabolso.mock.validator.MonthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = MonthValidator.class)
@Target( { METHOD, FIELD, CONSTRUCTOR, PARAMETER, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface MonthConstraint {
    String message() default "Invalid month. Month values must be between 1 and 12.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
