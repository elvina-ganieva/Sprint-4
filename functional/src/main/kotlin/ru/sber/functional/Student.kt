package ru.sber.functional

data class Student(
    val firstName: String,
    val lastName: String,
    val middleName: String = "отсутствует",
    val age: Int = 30,
    val averageRate: Double,
    val city: String = "отсутствует",
    val specialization: String = "отсутствует",
    val prevEducation: String? = "отсутствует",
)
