data class Car(val manufactory: Manufactory, val model:String,
               val gearbox:String, val marketList:List<Market>){

    val name = manufactory.toString() + model
}
