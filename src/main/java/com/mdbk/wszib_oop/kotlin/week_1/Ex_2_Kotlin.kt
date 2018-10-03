package com.mdbk.wszib_oop.kotlin.week_1

/**
 * Exercise 2:
 * Given 3 int values, a b c, return their sum. However, if one of the values is 13 then it does not count towards
 * the sum and values to its right do not count. So for example, if b is 13, then both b anc c do not count.
 */
object Ex_2_Kotlin {

    fun sumTillThirteen(a: Int, b: Int, c: Int): Int =
            arrayOf(a, b, c).takeWhile { it < 13 }.sum()
}