package com.guiabolso.mock.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guiabolso.mock.controller.request.TransactionRequest;
import com.guiabolso.mock.dto.TransactionDto;
import com.guiabolso.mock.service.TransactionServiceInterface;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionControllerTest {

    @MockBean
    private ObjectMapper objectMapper;

    @MockBean
    private TransactionServiceInterface transactionService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetTransactions() {
        TransactionRequest transactionRequest = new TransactionRequest(1500, 2020, 1);
        List<TransactionDto> list = new ArrayList<>();
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(1500);
        transactionDto.setDate(164654653L);
        transactionDto.setAmount(15432);
        transactionDto.setDescription("testing controller");
        list.add(0,transactionDto);

        given(transactionService.getTransactions(transactionRequest)).willReturn(list);

        ResponseEntity<TransactionDto[]> response = restTemplate.getForEntity("/mock/1500/transacoes/2020/1", TransactionDto[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("testing controller", Arrays
                .stream(Objects.requireNonNull(response.getBody()))
                .map(TransactionDto::getDescription)
                .collect(Collectors.joining()));

    }

    @Test
    public void testHeaderIsPresent() {
        ResponseEntity<TransactionDto[]> respone = restTemplate.getForEntity("/mock/1500/transacoes/2020/1", TransactionDto[].class);

        assertEquals(HttpStatus.OK, respone.getStatusCode());
        assertNotNull(respone.getHeaders());
    }
}
