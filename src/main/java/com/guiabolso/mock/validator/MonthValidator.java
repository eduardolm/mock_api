package com.guiabolso.mock.validator;

import com.guiabolso.mock.validator.constraint.MonthConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MonthValidator implements ConstraintValidator<MonthConstraint, Integer> {
    @Override
    public void initialize(MonthConstraint month) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value !=null && value >= 1 && value <= 12;
    }
}
