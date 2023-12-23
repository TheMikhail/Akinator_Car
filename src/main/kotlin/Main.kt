import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.util.*
import java.util.List
import java.util.function.Predicate


@Composable
@Preview
fun App() {
    //var text by remember { mutableStateOf("Hello, World!") }

    val questionJDM = QuestionJDM()
    val car1 = Car(Manufactory.HONDA,"Civic","manual", listOf(Market.JDM))
    val car2 = Car(Manufactory.VAZ, "2111", "manual", listOf(Market.RDM))
    val car3 = Car(Manufactory.TOYOTA, "Corona", "automatic", listOf(Market.JDM))
    val car4 = Car(Manufactory.MERCEDES, "w140", "manual", listOf(Market.EDM))
    val car5 = Car(Manufactory.BMW, "t39", "manual", listOf(Market.EDM))
    val carfilter = List.of(car1, car2, car3, car4, car5)

    var TextQuestion:String
    MaterialTheme {
        Column (modifier = Modifier.fillMaxSize().padding(bottom = 35.dp) ,verticalArrangement = Arrangement.Bottom){
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                TextButton(onClick = {

                    val jdmCar = carfilter.stream().filter(questionJDM.filter() as Predicate<in Car>?).toList()

                }) {
                    Text(text = "Да", fontSize = 32.sp)
                }

                TextButton(onClick = {

                }) {
                    Text(text = "Нет",fontSize = 32.sp)
                }

            }
        }
        Column (modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center){
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = questionJDM.description(), fontSize = 30.sp)
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
