package com.mdbk.wszib_oop.java.week_4

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class ChecksumValidatorTest {

    private val tested = ChecksumValidator()

    @ParameterizedTest
    @MethodSource("cardNumbers")
    fun `validates checksum`(arg: ChecksumArg) {
        val actual = tested.hasCorrectChecksum(arg.cardNumber)

        assertEquals(arg.expectedResult, actual)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun cardNumbers(): Stream<ChecksumArg> = Stream.of(
                ChecksumArg(listOf(1, 1, 1, 1, 1, 1, 1, 1, 1), false),
                ChecksumArg(listOf(0, 0, 0, 0, 0, 0, 0, 5, 1), true),
                ChecksumArg(listOf(0, 0, 0, 0, 0, 0, 0, 0, 0), true),
                ChecksumArg(listOf(3, 4, 5, 8, 8, 2, 8, 6, 5), true)
        )
    }

    data class ChecksumArg(val cardNumber: List<Int>, val expectedResult: Boolean)
}