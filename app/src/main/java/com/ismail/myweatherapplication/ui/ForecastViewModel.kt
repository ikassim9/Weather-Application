package com.ismail.myweatherapplication.ui

import androidx.lifecycle.ViewModel
import com.ismail.myweatherapplication.model.ForecastConditions
import com.ismail.myweatherapplication.model.LatitudeLongitude
import com.ismail.myweatherapplication.service.OpenWeatherMapApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


@HiltViewModel
class ForecastViewModel @Inject constructor(private val api: OpenWeatherMapApi) :ViewModel() {
    private val _forecastConditions = Channel<ForecastConditions>()

    val forecastConditions: Flow<ForecastConditions> = _forecastConditions.receiveAsFlow()

    fun fetchData() = runBlocking {
        val forecastConditions = api.getForecastConditions("55421")
        _forecastConditions.trySend(forecastConditions)
    }

    fun fetchDataByLocation(latitudeLongitude: LatitudeLongitude) = runBlocking {
        val forecastConditions = api.getForecastConditionsByLocation(latitudeLongitude.latitude, longitude = latitudeLongitude.longitude)
        _forecastConditions.trySend(forecastConditions)
    }
}