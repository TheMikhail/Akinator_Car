interface QuestionRepository {
    fun getQuestion(): MutableList<Question>
}