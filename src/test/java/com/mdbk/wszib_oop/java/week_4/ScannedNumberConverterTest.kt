package com.mdbk.wszib_oop.java.week_4

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ScannedNumberConverterTest {

    private val tested by lazy { ScannedNumberConverter() }

    @MethodSource("correctScannedNumbers")
    @ParameterizedTest
    fun `converts ScannedNumbers to Integers`(args: ScannedNumberArgs) {
        val actual = tested.convertScannedNumbersToIntegers(args.inputList)

        assertEquals(actual, args.expectedList)
    }

    @Test
    fun `converts unknown number to -1`() {
        val invalidNumber = ScannedNumber(false, false, true, true, false, false, true)
        val inputList = listOf(ScannedNumber.ZERO, ScannedNumber.THREE, invalidNumber)

        val actual = tested.convertScannedNumbersToIntegers(inputList)

        assertEquals(listOf(0, 3, -1), actual)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        private fun correctScannedNumbers(): Stream<ScannedNumberArgs> = Stream.of(
                ScannedNumberArgs(listOf(ScannedNumber.ZERO, ScannedNumber.EIGHT, ScannedNumber.SIX), listOf(0, 8, 6)),
                ScannedNumberArgs(
                        listOf(
                                ScannedNumber.ZERO,
                                ScannedNumber.SEVEN,
                                ScannedNumber.FIVE,
                                ScannedNumber.THREE,
                                ScannedNumber.ONE),
                        listOf(0, 7, 5, 3, 1)),
                ScannedNumberArgs(
                        listOf(ScannedNumber.ZERO),
                        listOf(0)
                )
        )
    }

    data class ScannedNumberArgs(val inputList: List<ScannedNumber>, val expectedList: List<Int>)
}