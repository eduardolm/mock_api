package com.guiabolso.mock.validator.constraint;

import com.guiabolso.mock.validator.IdValidator;
import com.guiabolso.mock.validator.YearValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = YearValidator.class)
@Target( { METHOD, FIELD, CONSTRUCTOR, PARAMETER, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface YearConstraint {
    String message() default "Invalid year. Year values must be between 1970 and 292278994.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
