package com.example.zjazd2.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.zjazd2.R;
import com.example.zjazd2.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    private EditText ETPersonWeight;
    private EditText ETPersonHeight;
    private EditText ETPersonAge;
    private Switch SAreYouAWoman;
    private Button BCalculate;
    private TextView TVBenHarInfo;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ETPersonWeight = root.findViewById(R.id.editTextTextPersonWeight);
        ETPersonHeight = root.findViewById(R.id.editTextTextPersonHeight);
        ETPersonAge = root.findViewById(R.id.editTextTextPersonAge);
        TVBenHarInfo = root.findViewById(R.id.textViewBenHarInfo);
        BCalculate = root.findViewById(R.id.buttonCalculate);
        SAreYouAWoman = root.findViewById(R.id.switchAreYouAWoman);

        BCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalculateBenHar();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void CalculateBenHar() {
        float weight = Float.parseFloat(ETPersonWeight.getText().toString());
        float height = Float.parseFloat(ETPersonHeight.getText().toString());
        float age = Float.parseFloat(ETPersonAge.getText().toString());

        float benHarCal = 0;

        if (SAreYouAWoman.isChecked()) {
            benHarCal = (float) ((66.473 + (13.7516 * weight) + (5.0033 * height)) - (6.755 * age));
        } else {
            benHarCal = (float) (655.0955 + (9.5634 * weight) + (1.8496 * height) - (4.6756 * age));
        }

        TVBenHarInfo.setText("Your BenHar is: " + String.format("%.2f", benHarCal));
    }
}