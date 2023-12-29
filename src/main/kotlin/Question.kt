import com.sun.net.httpserver.Filter

interface Question {

    fun description(): String

    fun checkCondition(answer: Boolean): (Car) -> Boolean
}