import java.util.function.Predicate

class QuestionGearboxManual : Question {
    fun description(): String {
        return "Вы хотите машину на механике?"
    }

    fun checkCondition(answer: Boolean): (Car) -> Boolean = { car ->
        car.gearbox.contains("manual")
    }
}