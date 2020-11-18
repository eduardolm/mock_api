package com.guiabolso.mock.validator;

import com.guiabolso.mock.validator.constraint.IdConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdValidator implements ConstraintValidator<IdConstraint, Integer> {
    @Override
    public void initialize(IdConstraint id) {
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && value >= 1000 && value <= 100000;
    }
}
