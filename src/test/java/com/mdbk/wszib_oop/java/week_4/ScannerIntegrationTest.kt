package com.mdbk.wszib_oop.java.week_4

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ScannerIntegrationTest {

    private val fileReader: FileReader = mock()
    private val accountNumberParser: AccountNumberParser = AccountNumberParser()
    private val converter = ScannedNumberConverter()
    private val validator = ChecksumValidator()

    private val tested by lazy { Scanner(fileReader, accountNumberParser, converter, validator) }

    @ParameterizedTest
    @MethodSource("cardNumbers")
    fun `returns list of account numbers`(args: ScannerArgs) {
        whenever(fileReader.readFile()).thenReturn(args.inputLines)

        val actual = tested.scanFile()

        assertEquals(args.expectedCardNumbers, actual)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun cardNumbers(): Stream<ScannerArgs> = Stream.of(
                ScannerArgs(
                        inputLines = listOf(
                                " _  _  _  _  _  _  _  _  _ ",
                                "| || || || || || || || || |",
                                "|_||_||_||_||_||_||_||_||_|",
                                "                           ",
                                "                           ",
                                "  |  |  |  |  |  |  |  |  |",
                                "  |  |  |  |  |  |  |  |  |",
                                "                           ",
                                "    _  _     _  _  _  _  _ ",
                                "  | _| _||_||_ |_   ||_||_|",
                                "  ||_  _|  | _||_|  ||_| _|",
                                "                           "
                        ),
                        expectedCardNumbers = listOf("000000000", "123456789")
                ),
                ScannerArgs(
                        inputLines = listOf(
                                " _  _  _  _  _  _  _  _  _ ",
                                "| || || || || || || || || |",
                                "|_||_||_||_||_||_||_||_||_|",
                                "                           "
                        ),
                        expectedCardNumbers = listOf("000000000")
                ),
                ScannerArgs(
                        inputLines = listOf(
                                "    _  _     _  _  _  _  _ ",
                                "  | _| _||_||_ |_   ||_||_|",
                                "  ||_  _|  | _||_|  ||_| _|",
                                "                           "
                        ),
                    expectedCardNumbers = listOf("123456789")
                )
        )
    }

    data class ScannerArgs(val inputLines: List<String>, val expectedCardNumbers: List<String>)
}