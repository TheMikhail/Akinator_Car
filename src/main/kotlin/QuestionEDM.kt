import java.util.function.Predicate

class QuestionEDM {
    fun description(): String {
        return "Вы хотите Европейскую машину?"
    }

    fun filter(): Predicate<*> {
        val edmFilter = Predicate<Car> { car: Car ->
            car.marketList.contains(
                Market.EDM
            )
        }
        return edmFilter
    }
}