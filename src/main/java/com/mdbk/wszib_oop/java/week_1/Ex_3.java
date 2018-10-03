package com.mdbk.wszib_oop.java.week_1;

/**
 * Given an array of ints, return true if sequence of numbers 1, 2, 3 appears in the array somewhere.
 */
public class Ex_3 {

    public static boolean hasOneTwoThreeSequence(int[] values) {
        int length = values.length;
        for (int index = 0; index < length; index++) {
            if (index + 2 < length) {
                if (values[index] == 1
                        && values[index + 1] == 2
                        && values[index + 2] == 3)
                    return true;
            }
        }
        return false;
    }
}
