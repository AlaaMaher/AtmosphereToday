package com.alaa.atmospheretoday.weather.domain.model.weather

import com.alaa.atmospheretoday.weather.domain.model.WeatherType
import java.time.LocalDateTime

data class Weather(
    val time: LocalDateTime,
    val temperatureInCelsius: String,
    val highTemperatureInCelsius: String,
    val lowTemperatureInCelsius: String,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType: WeatherType
)
