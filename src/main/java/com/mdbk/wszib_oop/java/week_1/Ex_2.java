package com.mdbk.wszib_oop.java.week_1;

/**
 * Exercise 2:
 * Given 3 int values, a b c, return their sum. However, if one of the values is 13 then it does not count towards
 * the sum and values to its right do not count. So for example, if b is 13, then both b anc c do not count.
 */
public class Ex_2 {

    public static int sumTillThirteen(int a, int b, int c) {
        int[] values = new int[]{a, b, c};
        int index = 0;
        int sum = 0;
        while (index < 3 && values[index] < 13) {
            sum += values[index];
            index++;
        }
        return sum;
    }
}
