package com.ismail.myweatherapplication.service

import com.ismail.myweatherapplication.model.CurrentConditions
import com.ismail.myweatherapplication.model.ForecastConditions
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApi {

    @GET("data/2.5/weather")

    suspend fun getCurrentConditions(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String = "faf2d0bbb6523eae491334ef72baf27b",
        @Query("units") units : String = "imperial"
    ): CurrentConditions


    @GET("data/2.5/forecast/daily")
    suspend fun getForecastConditions(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String = "faf2d0bbb6523eae491334ef72baf27b",
        @Query("units") units : String = "imperial"
    ): ForecastConditions
}