import java.util.function.Predicate

class QuestionUSDM {
    fun description(): String {
        return "Вы хотите Американскую машину?"
    }

    fun filter(): Predicate<*> {
        val usdmFilter = Predicate<Car> { car: Car ->
            car.marketList.contains(
                Market.USDM
            )
        }
        return usdmFilter
    }
}