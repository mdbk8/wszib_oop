package com.mdbk.wszib_oop.java.week_4

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class FileReaderTest {

    private val tested = FileReader()

    @Test
    fun `reads file`() {
        val actual = tested.readFile(File(this::class.java.classLoader.getResource("testInput.txt").file))

        val expected = listOf(
                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                "  ||_  _|  | _||_|  ||_| _|",
                "                           "
        )

        assertEquals(expected, actual)
    }
}