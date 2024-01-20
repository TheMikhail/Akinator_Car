class QuestionRepositoryClass : QuestionRepository {

    private val remainderQuestion: MutableList<Question> = mutableListOf(
        QuestionJDM, QuestionEDM, QuestionUSDM,
        QuestionRDM, QuestionGearboxAutomatic, QuestionGearboxManual
    )
    override fun getQuestion():MutableList<Question>{
        return remainderQuestion
    }
}