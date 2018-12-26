package com.mdbk.wszib_oop.java.week_4

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.io.File
import java.util.stream.Stream

class ScannerIntegrationTest {

    private val fileReader: FileReader = mock()
    private val accountNumberParser: AccountNumberParser = AccountNumberParser()
    private val converter = ScannedNumberConverter()
    private val creator = AccountNumberCreator(ChecksumValidator())
    private val accountNumberWriter: AccountNumberWriter = mock()

    private val tested by lazy { Scanner(fileReader, accountNumberParser, converter, creator, accountNumberWriter) }

    @ParameterizedTest
    @MethodSource("cardNumbers")
    fun `returns list of account numbers`(args: ScannerArgs) {
        whenever(fileReader.readFile(any())).thenReturn(args.inputLines)

        tested.scanFile(File(""))

        verify(accountNumberWriter).write(args.expectedAccountNumbers)
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
                                "                           ",
                                "    _  _     _  _  _  _  _ ",
                                "  | _| _||_ |_ |_   ||_||_|",
                                "  | _  _|  | _||_|  ||_| _|",
                                "                           "
                        ),
                        expectedAccountNumbers = listOf(
                                AccountNumber(listOf(0, 0, 0, 0, 0, 0, 0, 0, 0), AccountNumber.Status.OK),
                                AccountNumber(listOf(1, 1, 1, 1, 1, 1, 1, 1, 1), AccountNumber.Status.ERR),
                                AccountNumber(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9), AccountNumber.Status.OK),
                                AccountNumber(listOf(1, -1, 3, -1, 5, 6, 7, 8, 9), AccountNumber.Status.ILL)
                        )
                ),
                ScannerArgs(
                        inputLines = listOf(
                                " _  _  _  _  _  _  _  _  _ ",
                                "| || || || || || || || || |",
                                "|_||_||_||_||_||_||_||_||_|",
                                "                           "
                        ),
                        expectedAccountNumbers = listOf(
                                AccountNumber(listOf(0, 0, 0, 0, 0, 0, 0, 0, 0), AccountNumber.Status.OK)
                        )
                ),
                ScannerArgs(
                        inputLines = listOf(
                                "    _  _     _  _  _  _  _ ",
                                "  | _| _||_||_ |_   ||_||_|",
                                "  ||_  _|  | _||_|  ||_| _|",
                                "                           "
                        ),
                        expectedAccountNumbers = listOf(
                                AccountNumber(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9), AccountNumber.Status.OK)
                        )
                )
        )
    }

    data class ScannerArgs(val inputLines: List<String>, val expectedAccountNumbers: List<AccountNumber>)
}