abstract class Validator<T> {
    abstract fun validate(value: T?): List<ErrorCode>
}

class NameValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val str = value?.trim()

        if (str == null || str.isEmpty())
            return listOf(ErrorCode.EMPTY_LINE)
        if (str.length > 16)
            return listOf(ErrorCode.INVALID_LENGTH)
        if (!str.matches("[ЁёА-я]+".toRegex()))
            return listOf(ErrorCode.INVALID_CHARACTER)
        return listOf()
    }
}

class PhoneValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val str = value?.trim()

        if (str == null || str.isEmpty())
            return listOf(ErrorCode.EMPTY_LINE)
        if (str.length != 11)
            return listOf(ErrorCode.INVALID_LENGTH)
        if (!str.matches("[0-9]+".toRegex()))
            return listOf(ErrorCode.INVALID_CHARACTER)
        if (!str.startsWith('7') && !value.startsWith('8'))
            return listOf(ErrorCode.INVALID_FORMAT)
        return listOf()
    }
}

class EmailValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val str = value?.trim()

        if (str == null || str.isEmpty())
            return listOf(ErrorCode.EMPTY_LINE)
        if (str.length > 32)
            return listOf(ErrorCode.INVALID_LENGTH)
        if (!str.matches("[A-Za-z]+@[A-Za-z]+\\.[A-Za-z]+".toRegex()))
            return listOf(ErrorCode.INVALID_FORMAT)
        return listOf()
    }
}

class SnilsValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val str = value?.trim()

        if (str == null || str.isEmpty())
            return listOf(ErrorCode.EMPTY_LINE)
        if (str.length != 11)
            return listOf(ErrorCode.INVALID_LENGTH)
        if (!str.matches("[0-9]+".toRegex()))
            return listOf(ErrorCode.INVALID_CHARACTER)

        val controlNumberActual = str.substring(9, 11).toInt()
        var controlNumberExpected = 0
        for (i in 1..9)
            controlNumberExpected += str[i - 1].digitToInt() * (10 - i)
        controlNumberExpected %= 101
        if (controlNumberExpected == 100) controlNumberExpected = 0
        if (controlNumberActual != controlNumberExpected)
            return listOf(ErrorCode.INVALID_SNILS)
        return listOf()
    }
}
