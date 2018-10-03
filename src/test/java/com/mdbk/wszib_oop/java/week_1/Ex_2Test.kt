package com.mdbk.wszib_oop.java.week_1

import com.mdbk.wszib_oop.kotlin.week_1.Ex_2_Kotlin
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Ex_2Test {

    @ParameterizedTest
    @MethodSource("args")
    fun `java sums till 13 correctly`(a: Int, b: Int, c: Int, expectedSum: Int) {
        assertEquals(expectedSum, Ex_2.sumTillThirteen(a, b, c))
    }

    @ParameterizedTest
    @MethodSource("args")
    fun `kotlin sums till 13 correctly`(a: Int, b: Int, c: Int, expectedSum: Int) {
        assertEquals(expectedSum, Ex_2_Kotlin.sumTillThirteen(a, b, c))
    }

    companion object {

        @JvmStatic
        @Suppress("unused")
        fun args(): Stream<Arguments> {
            return Stream.of(
                    Arguments.of(1, 3, 4, 8),
                    Arguments.of(1, 13, 4, 1),
                    Arguments.of(-10, 0, 3, -7),
                    Arguments.of(4, 3, 13, 7),
                    Arguments.of(13, 3, 2, 0)
            )
        }
    }

}