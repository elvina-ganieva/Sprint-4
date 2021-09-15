class ValidationException(val errorCode: Array<ErrorCode>) : RuntimeException(errorCode.joinToString(",") { it.msg })

enum class ErrorCode(val code: Int, val msg: String) {
    INVALID_CHARACTER(100, "Недопустимый символ"),
    EMPTY_LINE(101, "Недопустимые пустые поля"),
    INVALID_LENGTH(102, "Недопустимая длина строки"),
    INVALID_PHONE_NUMBER_START(103, "Недопустимый номер телефона"),
    INVALID_SNILS(104, "Недопустимый номер снилс")

}