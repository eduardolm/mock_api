package com.guiabolso.mock.helper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperationHelperTest {

    private final OperationHelper operationHelper = new OperationHelper();

    @Test
    public void testIsLeapYear() {
        int[] years = new int[] {2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013,
                2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021};

        for (int testYear : years) {
            switch (testYear) {
                case 2000:
                case 2004:
                case 2008:
                case 2012:
                case 2016:
                case 2020:
                    assertTrue(operationHelper.isLeapYear(testYear));
                    break;
                case 2001:
                case 2002:
                case 2003:
                case 2005:
                case 2006:
                case 2007:
                case 2009:
                case 2010:
                case 2011:
                case 2013:
                case 2014:
                case 2015:
                case 2017:
                case 2018:
                case 2019:
                case 2021:
                    assertFalse(operationHelper.isLeapYear(testYear));
            }
        }
    }

    @Test
    public void testGetMaxDaysOfMonth() {
        int actualNumberOfDays = operationHelper.getMaxDaysOfMonth(2020, 5);
        int actualNumberOfDays2 = operationHelper.getMaxDaysOfMonth(2020, 4);
        int actualNumberOfDays3 = operationHelper.getMaxDaysOfMonth(2020, 2);
        int actualNumberOfDays4 = operationHelper.getMaxDaysOfMonth(2019, 2);

        assertEquals(31, actualNumberOfDays);
        assertEquals(30, actualNumberOfDays2);
        assertEquals(29, actualNumberOfDays3);
        assertEquals(28, actualNumberOfDays4);
    }

    @Test
    public void testGetQuantity() {
        int id = 2432;
        int month = 12;
        int id2 = 99999;

        assertEquals(24, operationHelper.getQuantity(id, month));
        assertEquals(108, operationHelper.getQuantity(id2, month));
    }

    @Test
    public void testGetRanomDay() {
        int year = 2020;
        int month = 5;
        int month2 = 5;

        assertNotEquals(operationHelper.getRandomDay(year, month), operationHelper.getRandomDay(year, month2));
    }

    @Test
    public void testGetTimestamp() {
        long[] testDates = operationHelper.getTimestamp(2020, 10, 20);

        assertNotEquals(testDates[0], testDates[1]);
        assertNotEquals(testDates[2], testDates[4]);
        assertNotEquals(testDates[5], testDates[6]);
        assertEquals(20, testDates.length);
    }

    @Test
    public void testGetTransactionValue() {
        int[] testValues = operationHelper.getTransactionValue(3245, 30);

        assertNotEquals(testValues[0], testValues[1]);
        assertNotEquals(testValues[2], testValues[4]);
        assertNotEquals(testValues[5], testValues[6]);
        assertEquals(30, testValues.length);
    }

    @Test
    public void testGetDescription() {
        String[] testDescriptions = operationHelper.getDescription(108);

        assertNotEquals(testDescriptions[0], testDescriptions[1]);
        assertNotEquals(testDescriptions[2], testDescriptions[4]);
        assertNotEquals(testDescriptions[5], testDescriptions[6]);
        assertNotEquals(testDescriptions[7], testDescriptions[8]);
        assertNotEquals(testDescriptions[9], testDescriptions[10]);
        assertNotEquals(testDescriptions[11], testDescriptions[12]);
        assertNotEquals(testDescriptions[13], testDescriptions[14]);
        assertNotEquals(testDescriptions[15], testDescriptions[16]);
        assertNotEquals(testDescriptions[17], testDescriptions[18]);
        assertNotNull(testDescriptions);
        assertNotNull(testDescriptions[34]);
        assertEquals(108, testDescriptions.length);
    }
}
