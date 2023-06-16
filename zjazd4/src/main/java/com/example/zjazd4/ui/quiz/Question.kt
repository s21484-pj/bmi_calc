package com.example.zjazd4.ui.quiz

class Question(s: String, s1: String, s2: String, s3: String, s4: String, i: Int) {
    private var questionText: String? = null
    private var option1: String? = null
    private var option2: String? = null
    private var option3: String? = null
    private var option4: String? = null
    private var correctOption = 0

    fun getQuestionText(): String? {
        return questionText
    }

    fun getCorrectOption(): Int {
        return correctOption
    }

    fun getOptions(): Array<String?> {
        return arrayOf(option1, option2, option3, option4)
    }
}