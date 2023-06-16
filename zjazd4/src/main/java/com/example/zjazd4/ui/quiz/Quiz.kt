package com.example.zjazd4.ui.quiz

class Quiz {
    private var questions: ArrayList<Question>? = null
    private var currentQuestionIndex = 0
    private var correctAnswers = 0

    fun Quiz() {
        questions = ArrayList()
        currentQuestionIndex = 0
        correctAnswers = 0
        addQuestions()
    }

    private fun addQuestions() {
        questions?.add(Question("Jaki jest zdrowy sposób zwiększenia spożycia błonnika w diecie?", "A) Zwiększenie spożycia przetworzonej żywności.", "B) Spożywanie większej ilości świeżych owoców, warzyw i pełnoziarnistych produktów.", "C) Ograniczenie spożycia wody.", "D) Zwiększenie ilości słodyczy i przekąsek.", 2))
        questions?.add(Question("Co to jest indeks glikemiczny (IG)?", "A) Skala określająca zawartość witamin i minerałów w produkcie spożywczym.", "B) Liczba kalorii w posiłku.", "C) Skala określająca wpływ danego pokarmu na poziom glukozy we krwi.", "D) Liczba białek w produkcie spożywczym.", 3))
        questions?.add(Question("Który z poniższych składników jest tłuszczem nasyconym?", "A) Olej rzepakowy.", "B) Masło orzechowe.", "C) Awokado.", "D) Oliwa z oliwek.", 2))
        questions?.add(Question("Jaka jest zalecana ilość spożywania wody dziennie?", "A) 1 szklanka.", "B) 4-6 szklanek.", "C) 8-10 szklanek.", "D) 12-14 szklanek.", 3))
        questions?.add(Question("Który z poniższych produktów zawiera najwięcej białka?", "A) Marchewka.", "B) Jajko.", "C) Makaron.", "D) Arbuz.", 2))
        questions?.add(Question("Które z poniższych źródeł zawiera zdrowe tłuszcze?", "A) Chipsy ziemniaczane.", "B) Orzechy włoskie.", "C) Fast food.", "D) Cukier.", 2))
    }

    fun getCurrentQuestion(): Question {
        return questions!![currentQuestionIndex]
    }

    fun answerQuestion(selectedOption: Int) {
        if (selectedOption == getCurrentQuestion().getCorrectOption()) {
            correctAnswers++
        }
        currentQuestionIndex++
    }

    fun isQuizFinished(): Boolean {
        return currentQuestionIndex == questions!!.size
    }

    fun getCorrectAnswers(): Int {
        return correctAnswers
    }

    fun getTotalQuestions(): Int {
        return questions!!.size
    }

    fun getQuizPercentage(): Double {
        return correctAnswers.toDouble() / questions!!.size * 100
    }
}