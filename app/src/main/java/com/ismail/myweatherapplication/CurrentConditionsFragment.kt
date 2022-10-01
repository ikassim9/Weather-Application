package com.ismail.myweatherapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ismail.myweatherapplication.databinding.FragmentCurrentConditionsBinding


class CurrentConditionsFragment : Fragment(R.layout.fragment_current_conditions) {
    private lateinit var binding: FragmentCurrentConditionsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCurrentConditionsBinding.bind(view)
        binding.forecastBtn.setOnClickListener {
              findNavController().navigate(R.id.action_currentConditionsFragment_to_forecastFragment)
        }

    }
}