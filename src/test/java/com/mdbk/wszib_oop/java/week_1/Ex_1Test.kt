package com.mdbk.wszib_oop.java.week_1

import com.mdbk.wszib_oop.kotlin.week_1.Ex_1_Kotlin
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Ex_1Test {

    @ParameterizedTest
    @MethodSource("teenArguments")
    fun `java version returns true`(firstNum: Int, secondNum: Int) =
            assertTrue(Ex_1.isTeen(firstNum, secondNum))

    @ParameterizedTest
    @MethodSource("nonTeenArguments")
    fun `java version returns false`(firstNum: Int, secondNum: Int) =
            assertFalse(Ex_1.isTeen(firstNum, secondNum))

    @ParameterizedTest
    @MethodSource("teenArguments")
    fun `kotlin version returns true`(firstNum: Int, secondNum: Int) =
            assertTrue(Ex_1_Kotlin.isTeen(firstNum, secondNum))

    @ParameterizedTest
    @MethodSource("nonTeenArguments")
    fun `kotlin version returns false`(firstNum: Int, secondNum: Int) =
            assertFalse(Ex_1_Kotlin.isTeen(firstNum, secondNum))

    companion object {

        @JvmStatic
        @Suppress("unused")
        fun teenArguments(): Stream<Arguments> =
                Stream.of(
                        Arguments.of(12, 13),
                        Arguments.of(20, 13),
                        Arguments.of(19, 20),
                        Arguments.of(10, 15),
                        Arguments.of(16, 9),
                        Arguments.of(16, -9)
                )

        @JvmStatic
        @Suppress("unused")
        private fun nonTeenArguments(): Stream<Arguments> =
                Stream.of(
                        Arguments.of(13, 19),
                        Arguments.of(10, 10),
                        Arguments.of(13, 13),
                        Arguments.of(19, 19),
                        Arguments.of(16, 17),
                        Arguments.of(-1, -10)
                )
    }
}