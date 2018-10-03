package com.mdbk.wszib_oop.java.week_1

import com.mdbk.wszib_oop.kotlin.week_1.Ex_3_Kotlin
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Ex_3Test {

    @ParameterizedTest
    @MethodSource("args")
    fun `java finds one lwo three sequence correctly`(values: IntArray, hasSequence: Boolean) {
        assertEquals(hasSequence, Ex_3.hasOneTwoThreeSequence(values))
    }

    @ParameterizedTest
    @MethodSource("args")
    fun `kotlin finds one lwo three sequence correctly`(values: IntArray, hasSequence: Boolean) {
        assertEquals(hasSequence, Ex_3_Kotlin.hasOneTwoThreeSequence(values))
    }

    companion object {
        @JvmStatic
        @Suppress("unused")
        fun args(): Stream<Arguments> {
            return Stream.of(
                    Arguments.of(intArrayOf(1, 2, 3, 4, 5, 4), true),
                    Arguments.of(intArrayOf(1, 2, 4, 9, 1, 2, 3), true),
                    Arguments.of(intArrayOf(1, 2, 4, 9, 1, 2, 2), false),
                    Arguments.of(intArrayOf(3, 2, 1, 9, 1, 2, 2), false),
                    Arguments.of(intArrayOf(3, 2, 1, 1, 2, 3, 1), true)
            )
        }
    }


}