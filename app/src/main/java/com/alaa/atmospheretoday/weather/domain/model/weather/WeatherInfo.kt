package com.alaa.atmospheretoday.weather.domain.model.weather


data class WeatherInfo(
    val dailyWeatherData : Map<Int, List<Weather>>,
    val currentWeatherData: Weather
)
