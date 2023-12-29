import java.util.function.Predicate

class QuestionEDM : Question{
    fun description(): String {
        return "Вы хотите Европейскую машину?"
    }

    fun checkCondition(answer: Boolean): (Car) -> Boolean = { car ->
        car.marketList.contains(Market.EDM)
    }
}