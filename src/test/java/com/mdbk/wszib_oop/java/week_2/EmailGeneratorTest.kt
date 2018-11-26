package com.mdbk.wszib_oop.java.week_2

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class EmailGeneratorTest {

    private val storageMock: EmailStorage = mock()
    private val tested = EmailGenerator(storageMock)

    @Test
    fun `generates proper emial when there is no other person with the same name and surname`() {
        val person = Person("John", "Gill")
        assertEquals("gill.john@mex.com", tested.generateEmail(person))
    }

    @ParameterizedTest
    @MethodSource("existingPersons")
    fun `generates proper email when there is already other person with the same name and surname`(testData: ExistingPerson) {
        whenever(storageMock.doesPersonExist(testData.person)).thenReturn(testData.howMany)

        assertEquals(testData.expectedEmail, tested.generateEmail(testData.person))
    }

    companion object {

        @Suppress("unused")
        @JvmStatic
        fun existingPersons(): Stream<ExistingPerson> = Stream.of(
                ExistingPerson(Person("Mat", "Dylan"), 1, "dylan.mat2@mex.com"),
                ExistingPerson(Person("Jan", "Kowalski"), 100, "kowalski.jan101@mex.com")
        )
    }

    data class ExistingPerson(
            val person: Person,
            val howMany: Int,
            val expectedEmail: String
    )
}