package com.guiabolso.mock.dto;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

@Data
public class TransactionDto {

    @JsonIgnore
    private int id;
    private String description;
    private int amount;
    private long date;
}
