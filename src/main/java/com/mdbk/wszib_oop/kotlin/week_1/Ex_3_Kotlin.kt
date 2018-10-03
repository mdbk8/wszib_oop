package com.mdbk.wszib_oop.kotlin.week_1

/**
 * Given an array of ints, return true if sequence of numbers 1, 2, 3 appears in the array somewhere.
 */
object Ex_3_Kotlin {

    fun hasOneTwoThreeSequence(values: IntArray): Boolean {
        val size = values.size
        values.forEachIndexed { index, element ->
            if (index + 2 < size) {
                if (element == 1 && values[index + 1] == 2 && values[index + 2] == 3)
                    return true
            }
        }
        return false
    }
}