package com.mdbk.wszib_oop.java.week_4

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Test

class ScannerTest {

    private val fileReader: FileReader = mock()
    private val accountNumberParser: AccountNumberParser = mock()

    private val tested by lazy { Scanner(fileReader, accountNumberParser, mock()) }

    @Test
    fun `filters empty lines for AccountNumberParser`() {
        val lines = listOf(
                " _  _  _  _  _  _  _  _  _ ",
                "| || || || || || || || || |",
                "|_||_||_||_||_||_||_||_||_|",
                "                           ",
                "                           ",
                "  |  |  |  |  |  |  |  |  |",
                "  |  |  |  |  |  |  |  |  |",
                "                           ",
                " _  _  _  _  _  _  _  _  _ ",
                " _| _| _| _| _| _| _| _| _|",
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ ",
                "                           "
        )
        whenever(fileReader.readFile()).thenReturn(lines)

        tested.scanFile()

        verify(accountNumberParser).parseAccountNumber(listOf(
                " _  _  _  _  _  _  _  _  _ ",
                "| || || || || || || || || |",
                "|_||_||_||_||_||_||_||_||_|"))
        verify(accountNumberParser).parseAccountNumber(listOf(
                "                           ",
                "  |  |  |  |  |  |  |  |  |",
                "  |  |  |  |  |  |  |  |  |"))
        verify(accountNumberParser).parseAccountNumber(listOf(
                " _  _  _  _  _  _  _  _  _ ",
                " _| _| _| _| _| _| _| _| _|",
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ "))
    }
}