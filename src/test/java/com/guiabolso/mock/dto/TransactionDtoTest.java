package com.guiabolso.mock.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionDtoTest {
    @Test
    public void testEqual() {
        assertFalse(new TransactionDto().canEqual("other"));
    }

    @Test
    public void testEquals() {
        assertFalse(new TransactionDto().equals("other"));
    }

    @Test
    public void testEquals2() {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setDate(LocalDate.of(2020, 03, 15)
                .atStartOfDay(ZoneOffset.UTC)
                .toInstant()
                .toEpochMilli());
        transactionDto.setAmount(15432);
        transactionDto.setDescription("testing description");

        assertFalse(new TransactionDto().equals(transactionDto));
    }

    @Test
    public void testConstructor() {

        TransactionDto transactionDto = new TransactionDto();

        assertEquals(0,transactionDto.getAmount());
        assertEquals(0,transactionDto.getDate());
        assertNull(transactionDto.getDescription());
        assertEquals("TransactionDto(description=null, amount=0, date=0)",
                transactionDto.toString());
    }

    @Test
    public void testGetDescription() {
        assertNull( new TransactionDto().getDescription());
    }

    @Test
    public void testGetDate() {
        assertEquals(0, new TransactionDto().getDate());
    }

    @Test
    public void testGetAmount() {
        assertEquals(0, new TransactionDto().getAmount());
    }

    @Test
    public void testHashCode() {
        assertEquals(205422, new TransactionDto().hashCode());
    }

    @Test
    public void testHashCode2() {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setDescription("description test");

        assertEquals(449179769, transactionDto.hashCode());
    }

    @Test
    public void testHashCode3() {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setDescription("description test");
        TransactionDto transaction1 = new TransactionDto();
        transaction1.setDescription("description test");

        assertEquals(transactionDto.hashCode(), transaction1.hashCode());
    }

    @Test
    public void testHashCode4() {
        long date = LocalDate.of(2020, 03, 15)
                .atStartOfDay(ZoneOffset.UTC)
                .toInstant()
                .toEpochMilli();
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setDate(date);

        assertEquals(-1779435714, transactionDto.hashCode());
    }

    @Test
    public void testHashCode5() {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setAmount(15432);

        assertEquals(53924214, transactionDto.hashCode());
    }

    @Test
    public void testSetDescription() {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setDescription("testing description");

        assertEquals("TransactionDto(description=testing description, amount=0, date=0)", transactionDto.toString());
    }

    @Test
    public void testSetDate() {
        TransactionDto transactionDto = new TransactionDto();
        long date = LocalDate.of(2020, 03, 15)
                .atStartOfDay(ZoneOffset.UTC)
                .toInstant()
                .toEpochMilli();
        transactionDto.setDate(date);

        assertEquals("TransactionDto(description=null, amount=0, date=1584230400000)", transactionDto.toString());
    }

    @Test
    public void testSetAmount() {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setAmount(15432);

        assertEquals("TransactionDto(description=null, amount=15432, date=0)", transactionDto.toString());
    }

    @Test
    public void testToString() {
        assertEquals("TransactionDto(description=null, amount=0, date=0)", new TransactionDto().toString());
    }
}

