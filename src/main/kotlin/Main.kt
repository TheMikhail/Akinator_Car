import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import Question as Question

@Composable
@Preview
fun app() {
    val car1 = Car(Manufactory.HONDA, "Civic", Gearbox.Manual, Market.JDM)
    val car2 = Car(Manufactory.VAZ, "2111", Gearbox.Manual, Market.RDM)
    val car3 = Car(Manufactory.TOYOTA, "Corona", Gearbox.Automatic, Market.JDM)
    val car4 = Car(Manufactory.MERCEDES, "w140", Gearbox.Automatic, Market.EDM)
    val car5 = Car(Manufactory.BMW, "e39", Gearbox.Manual, Market.EDM)
    val carFilter = listOf(car1, car2, car3, car4, car5)

    val filteredCars = remember { mutableStateOf(carFilter) }
    val currentQuestion = remember { mutableStateOf(SelectNewQuestion.getNextQuestion()) }
    val question = currentQuestion.value
    if (question != null) {
        questionItem(question, onAnswer = { answer ->
            filteredCars.value = filteredCars.value.filterByAnswer(question, true)
            currentQuestion.value = SelectNewQuestion.getNextQuestion()
        })
    } else {
        val yourCar = filteredCars.value
        Text(text = "Ваша машина ${yourCar.single().name}")
    }
}

object SelectNewQuestion {
    private val remainderQuestion: MutableList<Question> = mutableListOf(
        QuestionJDM, QuestionEDM, QuestionUSDM,
        QuestionRDM, QuestionGearboxAutomatic, QuestionGearboxManual
    )

    fun getNextQuestion(): Question? {
        if (remainderQuestion.isEmpty())
            return null
        else {
            val randomQuestion = remainderQuestion.random()
            remainderQuestion.remove(randomQuestion)
            return randomQuestion
        }
    }

}

fun List<Car>.filterByAnswer(currentQuestion: Question, answer: Boolean) =
    filter { car -> currentQuestion.checkCondition(answer, car) }

@Composable
fun questionItem(question: Question, onAnswer: (Boolean) -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(bottom = 35.dp), verticalArrangement = Arrangement.Bottom) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            TextButton(onClick = {
                onAnswer(true)
            }
            ) {
                Text(text = "Да", fontSize = 32.sp)
            }
            TextButton(onClick = {
                onAnswer(false)
            }) {
                Text(text = "Нет", fontSize = 32.sp)
            }
        }
    }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = question.description())
        }
    }

}

fun main() = application {
    MaterialTheme {}
    Window(onCloseRequest = ::exitApplication) {
        app()
    }
}
