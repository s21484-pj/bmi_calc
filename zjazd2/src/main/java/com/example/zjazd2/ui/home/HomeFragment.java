package com.example.zjazd2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.zjazd2.R;
import com.example.zjazd2.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private EditText ETPersonWeight;
    private EditText ETPersonHeight;
    private Button BCalculate;
    private TextView BMIInfo;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ETPersonWeight = root.findViewById(R.id.editTextTextPersonWeight);
        ETPersonHeight = root.findViewById(R.id.editTextTextPersonHeight);
        BMIInfo = root.findViewById(R.id.textViewBMIInfo);
        BCalculate = root.findViewById(R.id.buttonCalculate);

        BCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                CalCulateBMI();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void CalCulateBMI() {
        float weight = Float.parseFloat(ETPersonWeight.getText().toString());
        float height = Float.parseFloat(ETPersonHeight.getText().toString());

        float bmi = (100*100*weight)/(height*height);

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
        BMIInfo.setText(builder);
    }
}