package com.guiabolso.mock.enums;

import java.util.HashMap;
import java.util.Map;

public enum Month {

    JAN(1),
    FEB(2),
    MAR(3),
    APR(4),
    MAY(5),
    JUN(6),
    JUL(7),
    AUG(8),
    SEP(9),
    OCT(10),
    NOV(11),
    DEC(12);

    public final int value;
    private static Map map = new HashMap<>();

    private Month(int value) {
        this.value = value;
    }

    static {
        for (Month month : Month.values()) {
            map.put(month.value, month);
        }
    }
    public static Month valueOf(int month) {
        return (Month) map.get(month);
    }

    public int getValue() {
        return value;
    }
}
