package com.mdbk.wszib_oop.java.week_4

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LineParserTest {

    private val parser = LineParser()

    @ParameterizedTest
    @MethodSource("properScannedNumbers")
    fun `creates proper ScannedNumber objects`(args: ScannedNumberArgs) {
        val actual = parser.parseLines(args.stringInput.lines())

        assertEquals(args.expectedList, actual)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun properScannedNumbers(): Stream<ScannedNumberArgs> = Stream.of(
                ScannedNumberArgs(
                        """
                    _  _  _  _  _  _  _  _  _
                   | || || || || || || || || |
                   |_||_||_||_||_||_||_||_||_|
                   """.trimIndent(),
                        List(9) { ScannedNumber.ZERO }
                ),
                ScannedNumberArgs(
                        stringInput = "                           \n" +
                                "  |  |  |  |  |  |  |  |  |\n" +
                                "  |  |  |  |  |  |  |  |  |",
                        expectedList = List(9) { ScannedNumber.ONE }
                ),
                ScannedNumberArgs(
                        " _  _  _  _  _  _  _  _  _ \n" +
                        " _| _| _| _| _| _| _| _| _|\n" +
                        "|_ |_ |_ |_ |_ |_ |_ |_ |_ ",
                        List(9) { ScannedNumber.TWO }
                ),
                ScannedNumberArgs(
                        " _  _  _  _  _  _  _  _  _ \n" +
                        " _| _| _| _| _| _| _| _| _|\n" +
                        " _| _| _| _| _| _| _| _| _| ",
                        List(9) { ScannedNumber.THREE }
                ),
                ScannedNumberArgs(
                        "                           \n" +
                        "|_||_||_||_||_||_||_||_||_|\n" +
                        "  |  |  |  |  |  |  |  |  | ",
                        List(9) { ScannedNumber.FOUR }
                ),
                ScannedNumberArgs(
                        " _  _  _  _  _  _  _  _  _ \n" +
                        "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
                        " _| _| _| _| _| _| _| _| _|",
                        List(9) { ScannedNumber.FIVE }
                ),
                ScannedNumberArgs(
                        " _  _  _  _  _  _  _  _  _ \n" +
                        "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
                        "|_||_||_||_||_||_||_||_||_|",
                        List(9) { ScannedNumber.SIX }
                ),
                ScannedNumberArgs(
                        " _  _  _  _  _  _  _  _  _ \n" +
                        "  |  |  |  |  |  |  |  |  |\n" +
                        "  |  |  |  |  |  |  |  |  |",
                        List(9) { ScannedNumber.SEVEN }
                ),
                ScannedNumberArgs(
                        " _  _  _  _  _  _  _  _  _ \n" +
                        "|_||_||_||_||_||_||_||_||_|\n" +
                        "|_||_||_||_||_||_||_||_||_|",
                        List(9) { ScannedNumber.EIGHT }
                ),
                ScannedNumberArgs(
                        " _  _  _  _  _  _  _  _  _ \n" +
                        "|_||_||_||_||_||_||_||_||_|\n" +
                        " _| _| _| _| _| _| _| _| _|",
                        List(9) { ScannedNumber.NINE }
                ),
                ScannedNumberArgs(
                        "    _  _     _  _  _  _  _ \n" +
                        "  | _| _||_||_ |_   ||_||_|\n" +
                        "  ||_  _|  | _||_|  ||_| _|",
                        listOf(
                                ScannedNumber.ONE,
                                ScannedNumber.TWO,
                                ScannedNumber.THREE,
                                ScannedNumber.FOUR,
                                ScannedNumber.FIVE,
                                ScannedNumber.SIX,
                                ScannedNumber.SEVEN,
                                ScannedNumber.EIGHT,
                                ScannedNumber.NINE
                        )
                )
        )
    }

    data class ScannedNumberArgs(val stringInput: String, val expectedList: List<ScannedNumber>)
}