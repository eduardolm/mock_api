package com.guiabolso.mock.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guiabolso.mock.controller.request.TransactionRequest;
import com.guiabolso.mock.dto.TransactionDto;
import com.guiabolso.mock.helper.OperationHelper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TransactionServiceTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final OperationHelper operationHelper = new OperationHelper();

    @Test
    public void testGetTransactions() {
        TransactionService transactionService = new TransactionService(objectMapper);
        TransactionRequest transactionRequest = new TransactionRequest(3456, 2018, 7);

        int quantity = operationHelper.getQuantity(transactionRequest.getId(), transactionRequest.getMonth());
        int[] amount = operationHelper.getTransactionValue(transactionRequest.getId(), quantity);
        long[] date = operationHelper.getTimestamp(transactionRequest.getYear(), transactionRequest.getMonth(), quantity);
        String[] description = operationHelper.getDescription(quantity);
        List<TransactionDto> testList = transactionService.getTransactions(transactionRequest);

        assertEquals(21, testList.size());
        assertEquals(21, amount.length);
        assertEquals(21, date.length);
        assertEquals(21, description.length);
        assertEquals(amount[7], testList.get(7).getAmount());
        assertNotEquals(date[18], testList.get(18).getDate());
        assertNotEquals(description[20], testList.get(20).getDescription());
        assertEquals(quantity, testList.size());
    }
}
