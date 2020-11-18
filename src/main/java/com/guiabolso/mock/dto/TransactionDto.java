package com.guiabolso.mock.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionDto {

    private String description;
    private int amount;
    private long date;
}
