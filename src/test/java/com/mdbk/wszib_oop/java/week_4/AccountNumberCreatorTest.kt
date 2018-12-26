package com.mdbk.wszib_oop.java.week_4

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class AccountNumberCreatorTest {

    private val checksumValidator: ChecksumValidator = mock()
    private val tested by lazy { AccountNumberCreator(checksumValidator) }

    @Test
    fun `checks for illegible number`() {
        val numbers = listOf(9, 3, 1, 4, 5, -1, 4, -1, 7)
        val expected = AccountNumber(numbers, AccountNumber.Status.ILL)

        val actual = tested.createAccountNumber(numbers)

        assertEquals(expected, actual)
    }

    @Test
    fun `checks for wrong checksum`() {
        val numbers = listOf(9, 3, 1, 4, 5, 1, 4, 1, 7)
        whenever(checksumValidator.hasCorrectChecksum(numbers)).thenReturn(false)
        val expected = AccountNumber(numbers, AccountNumber.Status.ERR)

        val actual = tested.createAccountNumber(numbers)

        assertEquals(expected, actual)
    }

    @Test
    fun `creates proper AccountNumber objects`() {
        val numbers = listOf(9, 3, 1, 4, 5, 1, 4, 1, 7)
        whenever(checksumValidator.hasCorrectChecksum(numbers)).thenReturn(true)
        val expected = AccountNumber(numbers, AccountNumber.Status.OK)

        val actual = tested.createAccountNumber(numbers)

        assertEquals(expected, actual)
    }
}