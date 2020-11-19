package com.guiabolso.mock.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonthTest {

    @Test
    public void testValueOf() {
        assertEquals(Month.JAN, Month.valueOf("JAN"));
        assertEquals(Month.JAN, Month.valueOf(1));
    }

    @Test
    public void testValues() {
        Month[] actualValuesResult = Month.values();

        assertEquals(12, actualValuesResult.length);
        assertEquals(Month.JAN, actualValuesResult[0]);
        assertEquals(Month.FEB, actualValuesResult[1]);
        assertEquals(Month.MAR, actualValuesResult[2]);
        assertEquals(Month.APR, actualValuesResult[3]);
        assertEquals(Month.MAY, actualValuesResult[4]);
        assertEquals(Month.JUN, actualValuesResult[5]);
        assertEquals(Month.JUL, actualValuesResult[6]);
        assertEquals(Month.AUG, actualValuesResult[7]);
        assertEquals(Month.SEP, actualValuesResult[8]);
        assertEquals(Month.OCT, actualValuesResult[9]);
        assertEquals(Month.NOV, actualValuesResult[10]);
        assertEquals(Month.DEC, actualValuesResult[11]);
    }
}
