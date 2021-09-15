package ru.sber.functional

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class StudentsGroupTest {

    @Test
    fun `filterByPredicate() should return a list with Students called Ryan`() {

        val expected = listOf(
            Student(firstName = "Райан", lastName = "Гослинг", averageRate = 5.5),
            Student(firstName = "Райан", lastName = "Рейнольдс", averageRate = 4.5)
        )
        val actual = StudentsGroup().filterByPredicate { Student -> Student.firstName == "Райан" }
        assertEquals(expected, actual)
    }

    @Test
    fun `filterByPredicate() should return a list with Students with 4,5 averageRate`() {

        val expected = listOf(
            Student(firstName = "Том", lastName = "Харди", averageRate = 4.5),
            Student(firstName = "Райан", lastName = "Рейнольдс", averageRate = 4.5)
        )
        val actual = StudentsGroup().filterByPredicate { Student -> Student.averageRate == 4.5 }
        assertEquals(expected, actual)
    }
}