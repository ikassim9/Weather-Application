package com.ismail.myweatherapplication.model

import com.squareup.moshi.Json


data class ForecastConditions(
    @Json(name = "list") val forecastData: List<ForecastData>
)

data class ForecastData(
    @Json(name = "temp") val temp: Temp,
    @Json(name = "weather") val weatherData: List<WeatherData>,
    @Json(name = "dt") val date: Long,
    @Json(name = "sunrise") val sunrise: Long,
    @Json(name = "sunset") val sunset: Long,

    ) {


    data class WeatherData(
        @Json(name = "icon") val iconName: String
    )


    data class Temp(
        @Json(name = "min") val min: Float,
        @Json(name = "max") val max: Float,
    )




}