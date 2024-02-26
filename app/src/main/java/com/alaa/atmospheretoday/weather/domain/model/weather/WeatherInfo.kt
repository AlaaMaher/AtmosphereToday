package com.alaa.atmospheretoday.weather.domain.model.weather

import com.alaa.atmospheretoday.weather.domain.model.weather.Weather

data class WeatherInfo(
//    val dailyWeatherData : Map<Int, List<Weather>>,
    val currentWeatherData: Weather
)
