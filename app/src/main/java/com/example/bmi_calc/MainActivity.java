package com.example.bmi_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("DefaultLocale")
    public void calculateBMI(View view) {
        EditText textWeight = findViewById(R.id.weight);
        EditText textHeight = findViewById(R.id.height);
        TextView result = findViewById(R.id.result);

        double weight = Double.parseDouble(String.valueOf(textWeight.getText()));
        double height = Double.parseDouble(String.valueOf(textHeight.getText()));
        double bmi = weight / Math.pow(height / 100, 2);

        StringBuilder builder = new StringBuilder();
        builder.append("Your BMI: ").append(String.format("%.2f", bmi)).append(". You're in the ");
        if (bmi < 18.5) {
            builder.append("underweight range");
        } else if (bmi < 25) {
            builder.append("healthy weight range");
        } else if (bmi < 30) {
            builder.append("overweight range");
        } else {
            builder.append("obese range");
        }
        result.setText(builder);
    }
}