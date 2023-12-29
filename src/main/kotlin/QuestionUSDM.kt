import java.util.function.Predicate

object QuestionUSDM : Question {
    override fun description(): String {
        return "Вы хотите Американскую машину?"
    }

   override fun checkCondition(answer: Boolean): (Car) -> Boolean = { car ->
        car.marketList.contains(Market.USDM)
    }
}