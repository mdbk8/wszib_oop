package com.mdbk.wszib_oop.java.week_x

import org.junit.jupiter.api.Test

class LineParserTest {

    val parser = LineParser()

    @Test
    fun `s`() {
       val testInput = """
            _
           | |
           |_|
       """.trimIndent()

        parser.parseLines(listOf(testInput))
    }
}