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
import java.util.*
import java.util.List
import javax.sql.rowset.Predicate
import kotlin.random.Random
import Question as Question


@Composable
@Preview
fun App() {
    //var text by remember { mutableStateOf("Hello, World!") }


    val car1 = Car(Manufactory.HONDA, "Civic", "manual", Market.JDM)
    val car2 = Car(Manufactory.VAZ, "2111", "manual", Market.RDM)
    val car3 = Car(Manufactory.TOYOTA, "Corona", "automatic", Market.JDM)
    val car4 = Car(Manufactory.MERCEDES, "w140", "manual", Market.EDM)
    val car5 = Car(Manufactory.BMW, "e39", "manual", Market.EDM)
    val carFilter = listOf(car1, car2, car3, car4, car5)

    var currentQuestion: Question

    currentQuestion = remember { mutableStateOf(Question) }
    QuestionItem(currentQuestion, onAnswer = { answer ->
        filteredCarList.filterByQuestionAnswer
        selectNewQuestion
    })
}

fun askNewQuestion(currentQuestion: Question){
    val currentQuestion : Question
    currentQuestion = selectNewQuestion.getNextQuestion()

}
object selectNewQuestion {
    val random = Random
    val remaindQuestion: MutableList<Question> = mutableListOf(
        QuestionJDM, QuestionEDM, QuestionUSDM,
        QuestionRDM, QuestionGearboxAutomatic, QuestionGearboxManual
    )
    fun getNextQuestion(): Question {
        val randomQuestion = remaindQuestion.random()
        remaindQuestion.remove(randomQuestion)
        return randomQuestion
    }

}
fun filterByQuestionAnswer(carFilter: List<Car>, currentQuestion: Question, predicate: (onAnswer: Boolean) -> Boolean): List<Car> {
    var filteredCarList = carFilter

return
}
@Composable
fun questionContent(carFilter: List<Car>, question: Question): List<Car> {
    return carFilter
}
@Composable
fun QuestionItem(question: Question, onAnswer: (Boolean) -> Unit) {
    var answer: Boolean
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
    val sc = Scanner(System.`in`)
    MaterialTheme {}
    Window(onCloseRequest = ::exitApplication) {
        App()

    }
}
