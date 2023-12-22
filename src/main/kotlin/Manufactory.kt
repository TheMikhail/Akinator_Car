class Manufactory {
    var HONDA: Manufactory? = null
    var TOYOTA: Manufactory? = null
    var BMW: Manufactory? = null
    var MERCEDES: Manufactory? = null
    var VAZ: Manufactory? = null;
    private var manufactory: String? = null

    fun Manufactory(manufactory: String?) {
        this.manufactory = manufactory
    }

    override fun toString(): String {
        return manufactory.toString()
    }
}