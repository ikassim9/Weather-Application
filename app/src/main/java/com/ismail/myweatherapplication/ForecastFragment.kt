package com.ismail.myweatherapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.ismail.myweatherapplication.databinding.FragmentForecastBinding


class ForecastFragment : Fragment(R.layout.fragment_forecast) {

    private val forecastData = listOf(
        DayForecast(1664413947L, 10L, 20L, ForecastTemp(10f, 33f),1023F, 50),
        DayForecast(1665457101, 10L, 20L, ForecastTemp(10f, 33f),1023F, 50),
        DayForecast(12L, 10L, 20L, ForecastTemp(10f, 33f),12F, 50),
        DayForecast(12L, 10L, 20L, ForecastTemp(10f, 33f),23F, 50),
        DayForecast(34L, 54L, 20L, ForecastTemp(10f, 33f),123F, 50),
        DayForecast(12L, 10L, 20L, ForecastTemp(10f, 33f),23F, 50),
        DayForecast(12L, 10L, 20L, ForecastTemp(10f, 33f),15523F, 50),
        DayForecast(12L, 10L, 20L, ForecastTemp(10f, 33f),1042F, 50),
        DayForecast(12L, 10L, 20L, ForecastTemp(10f, 33f),1023F, 50),
        DayForecast(33L, 10L, 20L, ForecastTemp(10f, 33f),166F, 50),
        DayForecast(12L, 10L, 20L, ForecastTemp(10f, 33f),1073F, 50)
    )

    private lateinit var binding: FragmentForecastBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForecastBinding.bind(view)
        binding.forecastList.adapter = ForecastAdapter(forecastData)
    }
}