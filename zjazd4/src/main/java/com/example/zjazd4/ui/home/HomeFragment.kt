package com.example.zjazd4.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.zjazd4.R
import com.example.zjazd4.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null

    private var ETPersonWeight: EditText? = null
    private var ETPersonHeight: EditText? = null
    private var BCalculate: Button? = null
    private var BMIInfo: TextView? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val homeViewModel: HomeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        ETPersonWeight = root.findViewById(R.id.editTextTextPersonWeight)
        ETPersonHeight = root.findViewById(R.id.editTextTextPersonHeight)
        BMIInfo = root.findViewById(R.id.textViewBMIInfo)
        BCalculate = root.findViewById(R.id.buttonCalculate)
        BCalculate!!.setOnClickListener(View.OnClickListener { CalCulateBMI() })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun CalCulateBMI() {
        val weight = ETPersonWeight!!.text.toString().toFloat()
        val height = ETPersonHeight!!.text.toString().toFloat()
        val bmi = 100 * 100 * weight / (height * height)
        val builder = StringBuilder()
        builder.append("Your BMI: ").append(String.format("%.2f", bmi)).append(". You're in the ")
        if (bmi < 18.5) {
            builder.append("underweight range")
        } else if (bmi < 25) {
            builder.append("healthy weight range")
        } else if (bmi < 30) {
            builder.append("overweight range")
        } else {
            builder.append("obese range")
        }
        BMIInfo!!.text = builder
    }
}