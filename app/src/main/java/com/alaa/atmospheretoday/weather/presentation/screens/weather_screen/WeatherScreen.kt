package com.alaa.atmospheretoday.weather.presentation.screens.weather_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alaa.atmospheretoday.weather.domain.model.WeatherType
import com.alaa.atmospheretoday.weather.domain.model.weather.Weather
import com.alaa.atmospheretoday.weather.domain.model.weather.WeatherInfo
import com.alaa.atmospheretoday.weather.presentation.components.WeatherCard
import com.alaa.atmospheretoday.weather.presentation.components.WeatherForecast
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherScreen(state: WeatherViewStates) {
    state.weatherInfo?.currentWeatherData?.let { currentWeather ->
        Box(modifier = Modifier.fillMaxSize()) {
            WeatherCard(state = state)
            WeatherForecast(state = state, modifier = Modifier.align(Alignment.BottomCenter))
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(showBackground = true)
fun WeatherScreenPreview() {

    val wt: WeatherType = WeatherType.fromWMO(81)
    val weather = Weather(
        LocalDateTime.now(),
        "19" + " \u2103",
        "24" + " \u2103",
        "10" + " \u2103",
        1000.14,
        5.6,
        76.4,
        wt
    )

    val weather2 = Weather(
        LocalDateTime.now(),
        "19" + " \u2103",
        "24" + " \u2103",
        "10" + " \u2103",
        1000.14,
        5.6,
        76.4,
        WeatherType.fromWMO(8)
    )

    val weather3 = Weather(
        LocalDateTime.now(),
        "19" + " \u2103",
        "24" + " \u2103",
        "10" + " \u2103",
        1000.14,
        5.6,
        76.4,
        WeatherType.fromWMO(99)

    )
    val weather4 = Weather(
        LocalDateTime.now(),
        "19" + " \u2103",
        "24" + " \u2103",
        "10" + " \u2103",
        1000.14,
        5.6,
        76.4,
        WeatherType.fromWMO(85)

    )
    val weather5 = Weather(
        LocalDateTime.now(),
        "19" + " \u2103",
        "24" + " \u2103",
        "10" + " \u2103",
        1000.14,
        5.6,
        76.4,
        WeatherType.fromWMO(0)
    )
    val weather6 = Weather(
        LocalDateTime.now(),
        "19" + " \u2103",
        "24" + " \u2103",
        "10" + " \u2103",
        1000.14,
        5.6,
        76.4,
        wt
    )
    val weatherList = listOf(weather, weather2, weather3, weather4, weather5, weather6)


    var weatherDay: Map<Int, List<Weather>> = mutableMapOf()
    weatherDay = weatherDay.plus(0 to weatherList)
    val weatherInfo = WeatherInfo(weatherDay, weather)
    val weatherViewStates = WeatherViewStates(false, weatherInfo)
    WeatherScreen(state = weatherViewStates)
}