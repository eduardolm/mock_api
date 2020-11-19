package com.guiabolso.mock.controller;

import com.guiabolso.mock.controller.request.TransactionRequest;
import com.guiabolso.mock.dto.TransactionDto;
import com.guiabolso.mock.service.TransactionServiceInterface;
import com.guiabolso.mock.validator.constraint.IdConstraint;
import com.guiabolso.mock.validator.constraint.MonthConstraint;
import com.guiabolso.mock.validator.constraint.YearConstraint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mock")
@Validated
public class TransactionController {

    private final TransactionServiceInterface transactionServiceInterface;

    public TransactionController(TransactionServiceInterface transactionServiceInterface) {
        this.transactionServiceInterface = transactionServiceInterface;
    }

    @GetMapping("/{id}/transacoes/{year}/{month}")
    public ResponseEntity getTransactions(@PathVariable(name = "id") @IdConstraint int id,
                                          @PathVariable(name = "year") @YearConstraint int year,
                                          @PathVariable(name = "month") @MonthConstraint int month) {


        TransactionRequest transactionRequest = new TransactionRequest(id, year, month);

        try {
            List<TransactionDto> response = transactionServiceInterface.getTransactions(transactionRequest);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        catch (Exception ex) {
            String body = ex.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        }

    }

}
