import java.util.function.Predicate

class QuestionRDM : Question{
    override fun description(): String {
        return "Вы хотите Российскую машину?"
    }

    override fun checkCondition(answer: Boolean): (Car) -> Boolean = { car ->
        car.marketList.contains(Market.RDM)
    }
}