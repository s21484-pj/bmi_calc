package com.example.zjazd4.ui.quiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.example.zjazd4.R
import java.util.*

class QuizFragment {

    private val mViewModel: QuizViewModel? = null
    private var questionTextView: TextView? = null
    private var optionsRadioGroup: RadioGroup? = null
    private var submitButton: Button? = null
    private var quiz: Quiz? = null

    fun newInstance(): QuizFragment {
        return QuizFragment()
    }

    @SuppressLint("MissingInflatedId")
    fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                     savedInstanceState: Bundle?): View? {
        val root: View = inflater.inflate(R.layout.fragment_quiz, container, false)
        questionTextView = root.findViewById(R.id.questionTextView)
        optionsRadioGroup = root.findViewById(R.id.optionsRadioGroup)
        submitButton = root.findViewById(R.id.submitButton)
        quiz = Quiz()
        displayQuestion(root)
        submitButton!!.setOnClickListener(View.OnClickListener {
            val selectedOptionId = optionsRadioGroup!!.checkedRadioButtonId
            if (selectedOptionId != -1) {
                val selectedOptionRadioButton = root.findViewById<RadioButton>(selectedOptionId)
                val selectedOption = optionsRadioGroup!!.indexOfChild(selectedOptionRadioButton) + 1
                quiz!!.answerQuestion(selectedOption)
                if (quiz!!.isQuizFinished()) {
                    showQuizResults()
                } else {
                    displayQuestion(root)
                }
            }
        })
        return root
    }


    private fun displayQuestion(root: View) {
        val currentQuestion: Question = quiz!!.getCurrentQuestion()
        questionTextView!!.text = currentQuestion.getQuestionText()
        val optionRadioButtons = arrayOfNulls<RadioButton>(4)
        optionRadioButtons[0] = root.findViewById(R.id.option1RadioButton)
        optionRadioButtons[1] = root.findViewById(R.id.option2RadioButton)
        optionRadioButtons[2] = root.findViewById(R.id.option3RadioButton)
        optionRadioButtons[3] = root.findViewById(R.id.option4RadioButton)
        for (i in 0..3) {
            optionRadioButtons[i]!!.text = currentQuestion.getOptions()!![i]
        }
        optionsRadioGroup!!.clearCheck()
    }

    private fun showQuizResults() {
        val correctAnswers: Int = quiz!!.getCorrectAnswers()
        val totalQuestions: Int = quiz!!.getTotalQuestions()
        val quizPercentage: Double = quiz!!.getQuizPercentage()
        val results = String.format(Locale.getDefault(), "Wynik: %d/%d (%.2f%%)", correctAnswers, totalQuestions, quizPercentage)
        questionTextView!!.text = results
        optionsRadioGroup!!.visibility = View.GONE
        submitButton!!.isEnabled = false
    }
}