import java.util.function.Predicate

class QuestionGearboxManual : Question {
    override fun description(): String {
        return "Вы хотите машину на механике?"
    }

    override fun checkCondition(answer: Boolean): (Car) -> Boolean = { car ->
        car.gearbox.contains("manual")
    }
}