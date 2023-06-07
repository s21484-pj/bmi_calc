package com.example.zjazd2.ui.quiz;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private final List<Question> questions;
    private int currentQuestionIndex;
    private int correctAnswers;

    public Quiz() {
        questions = new ArrayList<>();
        currentQuestionIndex = 0;
        correctAnswers = 0;
        addQuestions();
    }

    private void addQuestions() {
        questions.add(new Question("Jaki jest zdrowy sposób zwiększenia spożycia błonnika w diecie?", "A) Zwiększenie spożycia przetworzonej żywności.", "B) Spożywanie większej ilości świeżych owoców, warzyw i pełnoziarnistych produktów.", "C) Ograniczenie spożycia wody.", "D) Zwiększenie ilości słodyczy i przekąsek.", 2));
        questions.add(new Question("Co to jest indeks glikemiczny (IG)?", "A) Skala określająca zawartość witamin i minerałów w produkcie spożywczym.", "B) Liczba kalorii w posiłku.", "C) Skala określająca wpływ danego pokarmu na poziom glukozy we krwi.", "D) Liczba białek w produkcie spożywczym.", 3));
        questions.add(new Question("Który z poniższych składników jest tłuszczem nasyconym?", "A) Olej rzepakowy.", "B) Masło orzechowe.", "C) Awokado.", "D) Oliwa z oliwek.", 2));
        questions.add(new Question("Jaka jest zalecana ilość spożywania wody dziennie?", "A) 1 szklanka.", "B) 4-6 szklanek.", "C) 8-10 szklanek.", "D) 12-14 szklanek.", 3));
        questions.add(new Question("Który z poniższych produktów zawiera najwięcej białka?", "A) Marchewka.", "B) Jajko.", "C) Makaron.", "D) Arbuz.", 2));
        questions.add(new Question("Które z poniższych źródeł zawiera zdrowe tłuszcze?", "A) Chipsy ziemniaczane.", "B) Orzechy włoskie.", "C) Fast food.", "D) Cukier.", 2));
    }

    public Question getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }

    public void answerQuestion(int selectedOption) {
        if (selectedOption == getCurrentQuestion().getCorrectOption()) {
            correctAnswers++;
        }
        currentQuestionIndex++;
    }

    public boolean isQuizFinished() {
        return currentQuestionIndex == questions.size();
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    public double getQuizPercentage() {
        return (double) correctAnswers / questions.size() * 100;
    }
}