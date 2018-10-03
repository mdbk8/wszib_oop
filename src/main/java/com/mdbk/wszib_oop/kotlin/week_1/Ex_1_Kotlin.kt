package com.mdbk.wszib_oop.kotlin.week_1

/**
 * Exercise 1:
 * We'll say that a number is "teen" if it is in the range 13..19 inclusive. Given two int values,
 * return true if one or the other is teen, but not both.
 */
object Ex_1_Kotlin {

    private val range = 13..19

    fun isTeen(firstNum: Int, secondNum: Int): Boolean =
            if (firstNum in range) secondNum !in range
            else secondNum in range
}