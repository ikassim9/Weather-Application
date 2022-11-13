package com.ismail.myweatherapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ismail.myweatherapplication.model.CurrentConditions
import com.ismail.myweatherapplication.service.OpenWeatherMapApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow


@HiltViewModel
class CurrentConditionsViewModel @Inject constructor(private val api: OpenWeatherMapApi) :ViewModel() {
    private val _currentConditions = Channel<CurrentConditions>()

    val currentConditions: Flow<CurrentConditions> = _currentConditions.receiveAsFlow()

    fun fetchData() = runBlocking {
        val currentConditions = api.getCurrentConditions("55421")
        _currentConditions.trySend(currentConditions)
    }
}