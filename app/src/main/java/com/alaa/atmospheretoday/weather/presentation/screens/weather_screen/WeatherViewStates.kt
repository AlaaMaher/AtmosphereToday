package com.alaa.atmospheretoday.weather.presentation.screens.weather_screen

import com.alaa.atmospheretoday.weather.domain.model.weather.WeatherInfo

data class WeatherViewStates(
    val isLoading: Boolean = false,
    val weatherInfo: WeatherInfo? = null,
    val error: String? = null
)