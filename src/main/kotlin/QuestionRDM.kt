import java.util.function.Predicate

class QuestionRDM : Question{
    fun description(): String {
        return "Вы хотите Российскую машину?"
    }

    fun checkCondition(answer: Boolean): (Car) -> Boolean = { car ->
        car.marketList.contains(Market.RDM)
    }
}