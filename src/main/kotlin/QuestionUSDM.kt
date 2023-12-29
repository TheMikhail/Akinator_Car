import java.util.function.Predicate

class QuestionUSDM : Question {
    fun description(): String {
        return "Вы хотите Американскую машину?"
    }

    fun checkCondition(answer: Boolean): (Car) -> Boolean = { car ->
        car.marketList.contains(Market.USDM)
    }
}