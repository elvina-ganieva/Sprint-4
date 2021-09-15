package ru.sber.functional

class StudentsGroup {

    private val students = listOf(
        Student(firstName = "Том", lastName = "Харди", averageRate = 4.5),
        Student(firstName = "Райан", lastName = "Гослинг", averageRate = 5.5),
        Student(firstName = "Райан", lastName = "Рейнольдс", averageRate = 4.5)
    )

    fun filterByPredicate(predicate: (Student) -> Boolean): List<Student> {
        return students.filter(predicate)
    }
}
