package com.mdbk.wszib_oop.java.week_2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InMemoryEmailStorageTest {

    private val tested = InMemoryEmailStorage()

    @Test
    fun `returns 0 when there is no other person with the same data`() {
        val person = Person("John", "Gill")

        assertEquals(0, tested.howManyPersonsExist(person))
    }

    @Test
    fun `saves number of persons with the same data and returns number of already existing`() {
        val person1 = Person("John", "Gill")
        val person2 = Person("John", "Gill")

        assertEquals(0, tested.howManyPersonsExist(person1))
        assertEquals(1, tested.howManyPersonsExist(person2))
    }
}