package com.guiabolso.mock.model;

import com.guiabolso.mock.validator.constraint.IdConstraint;
import lombok.Data;

@Data
public class Transaction {

    @IdConstraint
    private int id;
    private String description;
    private int amount;
    private long date;
}
