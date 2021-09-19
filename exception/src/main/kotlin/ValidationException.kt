class ValidationException(val errorCode: Array<ErrorCode>) : RuntimeException(errorCode.joinToString(",") { it.msg })

enum class ErrorCode(val code: Int, val msg: String) {
    EMPTY_LINE(101, "Недопустимые пустые поля"),
    INVALID_PHONE_FORMAT(103, "Недопустимый формат телефона"),
    INVALID_EMAIL_FORMAT(104, "Недопустимый формат почты"),
    INVALID_NAME_FORMAT(105, "Недопустимый формат имени"),
    INVALID_SNILS(106, "Недопустимый номер снилс")

}