class Car {
    var manufactory: Manufactory? = null
    var model: String? = null
    var gearbox: String? = null
    var marketList: List<Market> = ArrayList<Market>()
    fun getName(): String {
        return manufactory.toString() + model
    }
}