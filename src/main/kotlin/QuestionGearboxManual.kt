import java.util.function.Predicate

class QuestionGearboxManual {
    fun description(): String {
        return "Вы хотите машину на механике?"
    }

    fun filter(): Predicate<*> {
        val manualFilter = Predicate { car: Car ->
            car.gearbox!!.contains(
                "manual"
            )
        }
        return manualFilter
    }
}