package com.guiabolso.mock.validator;

import com.guiabolso.mock.validator.constraint.YearConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class YearValidator implements ConstraintValidator<YearConstraint, Integer> {
    @Override
    public void initialize(YearConstraint year) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && value >= 1970 && value <= 292278994;
    }
}
