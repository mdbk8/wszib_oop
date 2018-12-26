package com.mdbk.wszib_oop.java.week_4

import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.rules.TemporaryFolder
import java.io.File
import java.nio.file.Files

class AccountNumberWriterTest {

    @Rule
    @JvmField
    val tempFolder = TemporaryFolder()

    lateinit var tempFile: File
    private val tested by lazy { AccountNumberWriter(tempFile) }

    @Test
    fun `writes account numbers to a file`() {
        tempFile = tempFolder.newFile("temp.txt")
        val accountNumbers = listOf(
                AccountNumber(listOf(1, 5, 4, 9, 0, 8, 7, 3, 9), AccountNumber.Status.OK),
                AccountNumber(listOf(1, 5, 4, 9, -1, 8, 7, 3, 9), AccountNumber.Status.ILL),
                AccountNumber(listOf(1, 5, 4, 0, 0, 8, 7, 3, 9), AccountNumber.Status.ERR)
        )
        val expected = listOf(
                "154908739",
                "1549?8739 ILL",
                "154008739 ERR"
        )

        tested.write(accountNumbers)

        val actual = Files.readAllLines(tempFile.toPath())
        assertEquals(expected, actual)
    }
}