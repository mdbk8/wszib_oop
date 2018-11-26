package com.mdbk.wszib_oop.java.week_2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EmailStorageTest {

    private val tested = EmailStorage()

    @Test
    fun `returns -1 when there is no other person with the same data`() {
        val person = Person("John", "Gill")

        assertEquals(-1, tested.doesPersonExist(person))
    }

    @Test
    fun `saves number of persons with the same data`() {
        val person1 = Person("John", "Gill")
        val person2 = Person("John", "Gill")

        assertEquals(-1, tested.doesPersonExist(person1))
        assertEquals(1, tested.doesPersonExist(person2))
    }
}