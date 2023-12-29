import java.util.function.Predicate

object QuestionEDM : Question{
   override fun description(): String {
        return "Вы хотите Европейскую машину?"
    }

    override fun checkCondition(answer: Boolean): (Car) -> Boolean = { car ->
        car.marketList.contains(Market.EDM)
    }
}