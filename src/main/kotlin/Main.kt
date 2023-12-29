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
import java.util.function.Predicate
import kotlin.random.Random


@Composable
@Preview
fun App() {
    //var text by remember { mutableStateOf("Hello, World!") }

    val questionJDM = QuestionJDM()
    val questionGearboxManual = QuestionGearboxManual()
    val questionEDM = QuestionEDM()
    val questionGearboxAutomatic = QuestionGearboxAutomatic()
    val questionRDM = QuestionRDM()
    val questionUSDM = QuestionUSDM()


    val car1 = Car(Manufactory.HONDA, "Civic", "manual", listOf(Market.JDM))
    val car2 = Car(Manufactory.VAZ, "2111", "manual", listOf(Market.RDM))
    val car3 = Car(Manufactory.TOYOTA, "Corona", "automatic", listOf(Market.JDM))
    val car4 = Car(Manufactory.MERCEDES, "w140", "manual", listOf(Market.EDM))
    val car5 = Car(Manufactory.BMW, "t39", "manual", listOf(Market.EDM))
    val carFilter = List.of(car1, car2, car3, car4, car5)

    //val questionRandom = arrayOf(questionUSDM.description(),questionRDM.description(),questionRDM.description(),
    //    questionJDM.description(),questionGearboxAutomatic.description(),questionGearboxAutomatic.description())

    // val questionArray = questionRandom.size
    // val rand = Random.nextInt(questionArray)
    MaterialTheme {
        //var label = remember { mutableStateOf("${questionRandom[rand]}") }
        val label = remember { mutableStateOf(questionJDM.description()) }
        var answer:Boolean
        Column(modifier = Modifier.fillMaxSize().padding(bottom = 35.dp), verticalArrangement = Arrangement.Bottom) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                TextButton(onClick = {

                     answer = true
                    val jdmCar =
                        carFilter.filter(questionJDM.checkCondition(answer)).toList()

                    label.value = questionGearboxManual.description()


                }) {
                    Text(text = "Да", fontSize = 32.sp)


                }

                TextButton(onClick = {
                    label.value = questionEDM.description()
                }) {
                    Text(text = "Нет", fontSize = 32.sp)


                }


            }
        }
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(label.value, fontSize = 30.sp)


            }
        }


    }
}

fun main() = application {
    //это я так понял надо создавать объект


    val sc = Scanner(System.`in`)


    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
