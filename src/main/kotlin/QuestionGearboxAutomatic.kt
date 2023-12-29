import java.util.function.Predicate

class QuestionGearboxAutomatic : Question {
    fun description(): String {
        return "Вы хотите машину на автомате?"
    }

    fun checkCondition(answer: Boolean): (Car) -> Boolean = { car ->
        car.gearbox.contains("automatic")
    }
}