package com.alaa.atmospheretoday.weather.domain.model.weather

import android.location.Location
import com.alaa.atmospheretoday.weather.domain.model.WeatherType
import java.time.LocalTime

data class Weather(
    val temperatureInCelsius: String,
    val highTemperatureInCelsius: String,
    val lowTemperatureInCelsius: String,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType: WeatherType
)
