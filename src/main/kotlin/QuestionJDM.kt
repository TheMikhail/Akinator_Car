import java.util.function.Predicate

class QuestionJDM {
    fun description(): String {
        return "Вы хотите Японскую машину?"
    }

    fun filter(): Predicate<*> {
        val jdmFilter = Predicate<Car> { car: Car ->
            car.marketList.contains(
                Market.JDM
            )
        }
        return jdmFilter
    }
}