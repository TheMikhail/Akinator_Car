import java.util.function.Predicate

class QuestionGearboxAutomatic {
    fun description(): String {
        return "Вы хотите машину на автомате?"
    }

    fun filter(): Predicate<*> {
        val automaticFilter = Predicate { car: Car ->
            car.gearbox!!.contains(
                "automatic"
            )
        }
        return automaticFilter
    }
}