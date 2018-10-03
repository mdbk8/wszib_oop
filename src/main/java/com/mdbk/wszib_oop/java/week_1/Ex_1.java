package com.mdbk.wszib_oop.java.week_1;

/**
 * Exercise 1:
 * We'll say that a number is "teen" if it is in the range 13..19 inclusive. Given two int values,
 * return true if one or the other is teen, but not both.
 */
public class Ex_1 {

    private static int LOWER_BOUND = 13;
    private static int UPPER_BOUND_INCLUSIVE = 19;

    public static boolean isTeen(int firstNum, int secondNum) {
        if (isWithinBounds(firstNum)) {
            return isOutsideBounds(secondNum);
        } else {
            return isWithinBounds(secondNum);
        }
    }

    private static boolean isOutsideBounds(int num) {
        return num < LOWER_BOUND || num > UPPER_BOUND_INCLUSIVE;
    }

    private static boolean isWithinBounds(int num) {
        return num >= LOWER_BOUND && num <= UPPER_BOUND_INCLUSIVE;
    }
}
