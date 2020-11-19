package com.guiabolso.mock.helper;

import com.guiabolso.mock.enums.Month;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class OperationHelper {

    public int getRandomDay(int year, int month) {

        return ThreadLocalRandom.current().nextInt(1, getMaxDaysOfMonth(year, month) + 1);
    }

    public int[] getTransactionValue(int id, int quantity) {

        int c = Integer.parseInt(String.valueOf(id).substring(1, 3));
        int[] values = new int[quantity];

        for (int i = 0; i < quantity; i++) {
            values[i] = 3 * (int) (Math.pow(i, 3) - 30 * i + c);
        }
        return values;
    }

    public long[] getTimestamp(int year, int month, int quantity) {

        long[] dates = new long[quantity];
        for (int i = 0; i < quantity; i++) {
            dates[i] = LocalDate.of(year, month, getRandomDay(year, month)).
                    atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
        }
        return dates;
    }

    public int getQuantity(int id, int month) {

        return Integer.parseInt(String.valueOf(id).substring(0, 1)) * month;
    }

    public int getMaxDaysOfMonth(int year, int month){

        int max = 0;
        switch (Month.valueOf(month)) {
            case JAN:
            case DEC:
            case MAR:
            case MAY:
            case JUL:
            case AUG:
            case OCT:
                max = 31;
                break;
            case APR:
            case JUN:
            case SEP:
            case NOV:
                max = 30;
                break;
            case FEB:
                if (isLeapYear(year)) {
                    max = 29;
                }
                else {
                    max = 28;
                }
                break;
        }
        return max;
    }

    public boolean isLeapYear(int year) {
       if (year % 4 != 0) return false;
       else if (year % 400 == 0) return true;
       else return year % 100 != 0;
    }

    public String[] getDescription(int quantity) {

        String[] consonants = new String[] {"b", "c", "d", "f", "g", "h", "nh", "lh", "ch", "j",
                "k", "l", "m", "n", "p", "qu", "r", "rr", "s", "ss", "t", "v", "w", "x", "y", "z"};
        String[] vowels = new String[] {"a", "e", "i", "o", "u"};
        String vowel = "";
        String consonant = "";
        String sylable = "";
        int length = 5;
        String[] response = new String[quantity];

        for (int i = 0; i < quantity; i++) {
            int j = 0;
            while (j < 2) {
                Random random = new Random();
                StringBuilder str = new StringBuilder();
                int count = 0;
                while (count < length) {
                    vowel = vowels[random.nextInt(vowels.length - 1)];
                    consonant = consonants[random.nextInt(consonants.length - 1)];
                    sylable = consonant + vowel;
                    str.append(sylable);
                    count++;
                }
                if (j != 1) {
                    response[i] = str.toString();
                }
                else {
                    response[i] += (" " + str.toString());
                }
                j++;
            }
        }
        return response;
    }
}
