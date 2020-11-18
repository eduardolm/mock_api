package com.guiabolso.mock.validator.constraint;

import com.guiabolso.mock.validator.IdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = IdValidator.class)
@Target( { METHOD, FIELD, CONSTRUCTOR, PARAMETER, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface IdConstraint {
    String message() default "Invalid id. Id must be between 1000 and 100000.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
