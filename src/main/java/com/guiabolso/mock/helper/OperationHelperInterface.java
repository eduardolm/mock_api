package com.guiabolso.mock.helper;

public interface OperationHelperInterface {

    int getRandomDay(int year, int month);
    int[] getTransactionValue(int id, int quantity);
    long[] getTimestamp(int year, int month, int quantity);
    int getQuantity(int id, int month);
    int getMaxDaysOfMonth(int year, int month);
    boolean isLeapYear(int year);
    String[] getDescription(int quantity);
}
