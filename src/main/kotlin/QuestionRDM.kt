import java.util.function.Predicate

class QuestionRDM {
    fun description(): String {
        return "Вы хотите Российскую машину?"
    }

    fun filter(): Predicate<*> {
        val rdmFilter = Predicate<Car> { car: Car ->
            car.marketList.contains(
                Market.RDM
            )
        }
        return rdmFilter
    }
}