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
    val car = CarRepositoryClass()

    val filteredCars = remember { mutableStateOf(car.getCar()) }
    val currentQuestion = remember { mutableStateOf(SelectNewQuestion.getNextQuestion()) }
    val question = currentQuestion.value

    if (question != null) {
        questionItem(question, onAnswer = { answer ->
            filteredCars.value = filteredCars.value.filterByAnswer(question, answer)
            currentQuestion.value = SelectNewQuestion.getNextQuestion()
        })
    } else {
        val yourCar = filteredCars.value
        when (yourCar.size) {
            0 -> Text(text = "Вам не подходит ни одна существующая машина")
            1 -> Text(text = "Ваша машина ${yourCar.single().name}")
            else -> Text(
                text = "Вам подходят следующие авто: ${
                    yourCar.joinToString(
                        prefix = "Вам подходят авто: ",
                        transform = { car -> car.name })
                }"
            )
        }
    }
}

object SelectNewQuestion {
    val question = QuestionRepositoryClass()
    fun getNextQuestion(): Question? {
        if (question.getQuestion().isEmpty())
            return null
        else {
            val randomQuestion = question.getQuestion().random()
            question.getQuestion().remove(randomQuestion)
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
