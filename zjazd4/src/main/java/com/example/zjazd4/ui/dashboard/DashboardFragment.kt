package com.example.zjazd4.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.zjazd4.R
import com.example.zjazd4.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var binding: FragmentDashboardBinding? = null

    private var ETPersonWeight: EditText? = null
    private var ETPersonHeight: EditText? = null
    private var ETPersonAge: EditText? = null
    private var SAreYouAWoman: Switch? = null
    private var BCalculate: Button? = null
    private var TVBenHarInfo: TextView? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View {
        val dashboardViewModel: DashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        ETPersonWeight = root.findViewById(R.id.editTextTextPersonWeight)
        ETPersonHeight = root.findViewById(R.id.editTextTextPersonHeight)
        ETPersonAge = root.findViewById(R.id.editTextTextPersonAge)
        TVBenHarInfo = root.findViewById(R.id.textViewBenHarInfo)
        BCalculate = root.findViewById(R.id.buttonCalculate)
        SAreYouAWoman = root.findViewById(R.id.switchAreYouAWoman)
        BCalculate!!.setOnClickListener { CalculateBenHar() }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun CalculateBenHar() {
        val weight = ETPersonWeight!!.text.toString().toFloat()
        val height = ETPersonHeight!!.text.toString().toFloat()
        val age = ETPersonAge!!.text.toString().toFloat()
        var benHarCal = 0f
        benHarCal = if (SAreYouAWoman!!.isChecked) {
            (66.473 + 13.7516 * weight + 5.0033 * height - 6.755 * age).toFloat()
        } else {
            (655.0955 + 9.5634 * weight + 1.8496 * height - 4.6756 * age).toFloat()
        }
        TVBenHarInfo!!.text = "Your BenHar is: " + String.format("%.2f", benHarCal)
    }
}