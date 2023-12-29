import java.util.function.Predicate

class QuestionJDM : Question {
    fun description(): String {
        return "Вы хотите Японскую машину?"
    }

    fun checkCondition(answer: Boolean): (Car) -> Boolean = { car ->
        car.marketList.contains(Market.JDM)
    }


}