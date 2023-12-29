import java.util.function.Predicate

class QuestionJDM : Question {

    override fun description(): String {
        return "Вы хотите Японскую машину?"
    }

    override fun checkCondition(answer: Boolean): (Car) -> Boolean = { car ->
        car.marketList.contains(Market.JDM)
    }


}