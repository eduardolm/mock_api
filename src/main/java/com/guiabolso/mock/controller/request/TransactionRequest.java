package com.guiabolso.mock.controller.request;

import com.guiabolso.mock.validator.constraint.IdConstraint;
import com.guiabolso.mock.validator.constraint.MonthConstraint;
import com.guiabolso.mock.validator.constraint.YearConstraint;
import lombok.Data;

@Data
public class TransactionRequest {

    @IdConstraint
    private int id;
    @MonthConstraint
    private int month;
    @YearConstraint
    private int year;

    public TransactionRequest(int id, int year, int month) {
        this.id = id;
        this.year = year;
        this.month = month;
    }
}
