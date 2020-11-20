package com.guiabolso.mock.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guiabolso.mock.controller.request.TransactionRequest;
import com.guiabolso.mock.dto.TransactionDto;
import com.guiabolso.mock.helper.OperationHelperInterface;
import com.guiabolso.mock.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService implements TransactionServiceInterface{

    private final ObjectMapper objectMapper;

    private final OperationHelperInterface operationHelper;

    public TransactionService(ObjectMapper objectMapper, OperationHelperInterface operationHelper) {
        this.objectMapper = objectMapper;
        this.operationHelper = operationHelper;
    }

    public List<TransactionDto> getTransactions(TransactionRequest transactionRequest) {

        Transaction transaction = new Transaction();
        List<TransactionDto> list = new ArrayList<>();

        int quantity = operationHelper.getQuantity(transactionRequest.getId(), transactionRequest.getMonth());
        int[] amount = operationHelper.getTransactionValue(transactionRequest.getId(), quantity);
        long[] date = operationHelper.getTimestamp(transactionRequest.getYear(), transactionRequest.getMonth(), quantity);
        String[] description = operationHelper.getDescription(quantity);

        for (int i = 0; i< quantity; i++) {
            transaction.setAmount(amount[i]);
            transaction.setDate(date[i]);
            transaction.setDescription(description[i]);
            transaction.setId(transactionRequest.getId());
            list.add(objectMapper.convertValue(transaction, TransactionDto.class));
        }
        return list;
    }



}
