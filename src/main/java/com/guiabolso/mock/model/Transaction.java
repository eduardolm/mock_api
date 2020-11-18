package com.guiabolso.mock.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Transaction {

    @NotNull
    @Size(min = 4, max = 6)
    private int id;
    private String description;
    private int amount;
    private long date;
}
