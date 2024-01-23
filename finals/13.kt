import java.time.LocalDate



class FormValidator {
    fun validateName(name: String) {
        if (name.length !in 2..20 || !name[0].isUpperCase()) {
            throw InvalidException("Неверный формат имени. Он должен содержать от 2 до 20 символов и начинаться с заглавной буквы.")
        }
    }

    fun validateDateOfBirth(dateOfBirth: LocalDate) {
        val currentDate = LocalDate.now()
        val minDateOfBirth = LocalDate.of(1900, 1, 1)

        if (dateOfBirth.isBefore(minDateOfBirth) || dateOfBirth.isAfter(currentDate)) {
            throw InvalidException("Неверная дата рождения. Оно должно быть между 01.01.1900 и текущей датой.")
        }
    }


}


class InvalidException(message: String) : Throwable(message)

fun main() {
    val formValidator = FormValidator()

    try {
        formValidator.validateName("John Doe")
        formValidator.validateDateOfBirth(LocalDate.of(1990, 5, 15))
        println("Форма действительна. Отправка на сервер.")
    } catch (e: Throwable) {
        println("Проверка формы не удалась: ${e.message}")
    }
}

