package com.guiabolso.mock.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    @Test
    public void testEqual() {
        assertFalse(new Transaction().canEqual("other"));
    }

    @Test
    public void testEquals() {
        assertFalse(new Transaction().equals("other"));
    }

    @Test
    public void testEquals2() {
        Transaction transaction = new Transaction();
        transaction.setId(1);
        transaction.setDate(LocalDate.of(2020, 03, 15)
                .atStartOfDay(ZoneOffset.UTC)
                .toInstant()
                .toEpochMilli());
        transaction.setAmount(15432);
        transaction.setDescription("testing description");

        assertFalse(new Transaction().equals(transaction));
    }

    @Test
    public void testConstructor() {

        Transaction actualTransaction = new Transaction();

        assertEquals(0, actualTransaction.getId());
        assertEquals(0,actualTransaction.getAmount());
        assertEquals(0,actualTransaction.getDate());
        assertNull(actualTransaction.getDescription());
        assertEquals("Transaction(id=0, description=null, amount=0, date=0)",
                actualTransaction.toString());
    }

    @Test
    public void testGetId() {
        assertEquals(0, new Transaction().getId());
    }

    @Test
    public void testGetDescription() {
        assertNull( new Transaction().getDescription());
    }

    @Test
    public void testGetDate() {
        assertEquals(0, new Transaction().getDate());
    }

    @Test
    public void testGetAmount() {
        assertEquals(0, new Transaction().getAmount());
    }

    @Test
    public void testHashCode() {
        assertEquals(12117404, new Transaction().hashCode());
    }

    @Test
    public void testHashCode2() {
        Transaction transaction = new Transaction();
        transaction.setDescription("description test");

        assertEquals(461091751, transaction.hashCode());
    }

    @Test
    public void testHashCode3() {
        Transaction transaction = new Transaction();
        transaction.setDescription("description test");
        Transaction transaction1 = new Transaction();
        transaction1.setDescription("description test");

        assertEquals(transaction.hashCode(), transaction1.hashCode());
    }

    @Test
    public void testHashCode4() {
        long date = LocalDate.of(2020, 03, 15)
                .atStartOfDay(ZoneOffset.UTC)
                .toInstant()
                .toEpochMilli();
        Transaction transaction = new Transaction();
        transaction.setDate(date);

        assertEquals(-1767523732, transaction.hashCode());
    }

    @Test
    public void testHashCode5() {
        Transaction transaction = new Transaction();
        transaction.setAmount(15432);

        assertEquals(65836196, transaction.hashCode());
    }

    @Test
    public void testHashCode6() {
        Transaction transaction = new Transaction();
        transaction.setId(1540);

        assertEquals(328401064, transaction.hashCode());
    }

    @Test
    public void testSetId() {
        Transaction transaction = new Transaction();
        transaction.setId(3254);

        assertEquals("Transaction(id=3254, description=null, amount=0, date=0)", transaction.toString());
    }

    @Test
    public void testSetDescription() {
        Transaction transaction = new Transaction();
        transaction.setDescription("testing description");

        assertEquals("Transaction(id=0, description=testing description, amount=0, date=0)", transaction.toString());
    }

    @Test
    public void testSetDate() {
        Transaction transaction = new Transaction();
        long date = LocalDate.of(2020, 03, 15)
                .atStartOfDay(ZoneOffset.UTC)
                .toInstant()
                .toEpochMilli();
        transaction.setDate(date);

        assertEquals("Transaction(id=0, description=null, amount=0, date=1584230400000)", transaction.toString());
    }

    @Test
    public void testSetAmount() {
        Transaction transaction = new Transaction();
        transaction.setAmount(15432);

        assertEquals("Transaction(id=0, description=null, amount=15432, date=0)", transaction.toString());
    }

    @Test
    public void testToString() {
        assertEquals("Transaction(id=0, description=null, amount=0, date=0)", new Transaction().toString());
    }
}
