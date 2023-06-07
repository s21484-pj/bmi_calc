package com.example.zjazd2.ui.quiz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.zjazd2.R;

import java.util.Locale;

public class QuizFragment extends Fragment {

    private QuizViewModel mViewModel;
    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private Button submitButton;
    private Quiz quiz;

    public static QuizFragment newInstance() {
        return new QuizFragment();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_quiz, container, false);

        questionTextView = root.findViewById(R.id.questionTextView);
        optionsRadioGroup = root.findViewById(R.id.optionsRadioGroup);
        submitButton = root.findViewById(R.id.submitButton);

        quiz = new Quiz();

        displayQuestion(root);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionId = optionsRadioGroup.getCheckedRadioButtonId();
                if (selectedOptionId != -1) {
                    RadioButton selectedOptionRadioButton = root.findViewById(selectedOptionId);
                    int selectedOption = optionsRadioGroup.indexOfChild(selectedOptionRadioButton) + 1;
                    quiz.answerQuestion(selectedOption);

                    if (quiz.isQuizFinished()) {
                        // Quiz zakończony, wyświetlenie wyników
                        showQuizResults();
                    } else {
                        // Wyświetlenie kolejnego pytania
                        displayQuestion(root);
                    }
                }
            }
        });

        return root;
    }


    private void displayQuestion(View root) {
        Question currentQuestion = quiz.getCurrentQuestion();
        questionTextView.setText(currentQuestion.getQuestionText());
        RadioButton[] optionRadioButtons = new RadioButton[4];
        optionRadioButtons[0] = root.findViewById(R.id.option1RadioButton);
        optionRadioButtons[1] = root.findViewById(R.id.option2RadioButton);
        optionRadioButtons[2] = root.findViewById(R.id.option3RadioButton);
        optionRadioButtons[3] = root.findViewById(R.id.option4RadioButton);
        for (int i = 0; i < 4; i++) {
            optionRadioButtons[i].setText(currentQuestion.getOptions()[i]);
        }
        optionsRadioGroup.clearCheck();
    }

    private void showQuizResults() {
        int correctAnswers = quiz.getCorrectAnswers();
        int totalQuestions = quiz.getTotalQuestions();
        double quizPercentage = quiz.getQuizPercentage();
        String results = String.format(Locale.getDefault(), "Wynik: %d/%d (%.2f%%)", correctAnswers, totalQuestions, quizPercentage);
        questionTextView.setText(results);
        optionsRadioGroup.setVisibility(View.GONE);
        submitButton.setEnabled(false);
    }
}