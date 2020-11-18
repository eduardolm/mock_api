package com.guiabolso.mock.dto;

import lombok.Data;

@Data
public class TransactionDto {

    private String description;
    private int amount;
    private long date;
}
