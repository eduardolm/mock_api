package com.guiabolso.mock.service;

import com.guiabolso.mock.controller.request.TransactionRequest;
import com.guiabolso.mock.dto.TransactionDto;

import java.util.List;

public interface TransactionServiceInterface {

    List<TransactionDto> getTransactions(TransactionRequest transactionRequest);
    }
