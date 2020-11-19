package com.guiabolso.mock.controller.request;

import com.guiabolso.mock.model.Transaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TransactionRequestTest {

    @Test
    public void testEqual() {
        assertFalse(new TransactionRequest(1, 2020, 11).canEqual("other"));
    }

    @Test
    public void testEquals() {
        assertFalse(new TransactionRequest(1234, 2015, 3).equals("other"));
    }

    @Test
    public void testEquals2() {
        TransactionRequest transactionRequest = new TransactionRequest(3214, 2011, 2);

        assertFalse(new Transaction().equals(transactionRequest));
    }

    @Test
    public void testConstructor() {

        TransactionRequest transactionRequest = new TransactionRequest(10246, 2010, 10);

        assertEquals(10246, transactionRequest.getId());
        assertEquals(2010,transactionRequest.getYear());
        assertEquals(10,transactionRequest.getMonth());
        assertEquals("TransactionRequest(id=10246, month=10, year=2010)", transactionRequest.toString());
    }

    @Test
    public void testGetId() {
        assertEquals(3211, new TransactionRequest(3211, 2000, 8).getId());
    }

    @Test
    public void testGetYear() {
        assertEquals(1995, new TransactionRequest(10456, 1995, 4).getYear());
    }

    @Test
    public void testGetMonth() {
        assertEquals(6, new TransactionRequest(1234, 1988, 6).getMonth());
    }

    @Test
    public void testHashCode() {
        assertEquals(159052430, new TransactionRequest(45632, 2000, 1).hashCode());
    }

    @Test
    public void testHashCode2() {
        TransactionRequest transaction = new TransactionRequest(1000, 2020, 5);
        TransactionRequest transaction1 = new TransactionRequest(1000, 2020, 5);

        assertEquals(transaction.hashCode(), transaction1.hashCode());
    }

    @Test
    public void testSetId() {
        TransactionRequest transactionRequest = new TransactionRequest(1000, 2020, 6);
        transactionRequest.setId(3254);

        assertEquals("TransactionRequest(id=3254, month=6, year=2020)", transactionRequest.toString());
    }

    @Test
    public void testSetYear() {
        TransactionRequest transactionRequest = new TransactionRequest(1000, 2020,6);
        transactionRequest.setYear(2015);

        assertEquals("TransactionRequest(id=1000, month=6, year=2015)", transactionRequest.toString());
    }

    @Test
    public void testSetMonth() {
        TransactionRequest transactionRequest = new TransactionRequest(2020, 2020, 1);

        transactionRequest.setMonth(2);

        assertEquals("TransactionRequest(id=2020, month=2, year=2020)", transactionRequest.toString());
    }

    @Test
    public void testToString() {
        assertEquals("TransactionRequest(id=1000, month=3, year=2000)",
                new TransactionRequest(1000, 2000, 3).toString());
    }
}

