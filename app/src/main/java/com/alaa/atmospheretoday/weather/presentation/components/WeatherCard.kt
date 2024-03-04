package com.alaa.atmospheretoday.weather.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alaa.atmospheretoday.weather.domain.model.WeatherType
import com.alaa.atmospheretoday.weather.domain.model.weather.Weather
import com.alaa.atmospheretoday.weather.domain.model.weather.WeatherInfo
import com.alaa.atmospheretoday.weather.presentation.screens.weather_screen.WeatherViewStates
import java.time.LocalDateTime

@Composable
fun WeatherCard(
    state: WeatherViewStates, modifier: Modifier = Modifier
) {
    state.weatherInfo?.currentWeatherData?.let { currentWeather ->
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Box {
                Image(
                    painter = painterResource(id = currentWeather.weatherType.weatherBackground),
                    contentDescription = currentWeather.weatherType.weatherDesc,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )

                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(top = 70.dp)
                            .align(Alignment.TopCenter)
                    ) {

                        Image(
                            painter = painterResource(id = currentWeather.weatherType.iconRes),
                            contentDescription = "Weather Icon",
                            modifier = Modifier
                                .width(150.dp)
                        )

                        Text(
                            text = "Cairo",
                            fontSize = 34.sp,
                            color = Color.White,
                            style = MaterialTheme.typography.headlineMedium,
                        )

                        Text(
                            text = currentWeather.temperatureInCelsius,
                            fontSize = 50.sp,
                            style = MaterialTheme.typography.displaySmall,
                            color = Color.White
                        )

                        Text(
                            text = currentWeather.weatherType.weatherDesc,
                            fontSize = 30.sp,
                            color = Color.LightGray,
                            maxLines = 1,
                            style = MaterialTheme.typography.headlineMedium,

                            )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    vertical = 5.dp,
                                    horizontal = 100.dp
                                ),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly,
                        ) {
                            Text(
                                text = "H:${currentWeather.highTemperatureInCelsius}",
                                fontSize = 20.sp,
                                color = Color.White

                            )
                            Text(
                                text = "L:${currentWeather.lowTemperatureInCelsius}",
                                fontSize = 20.sp,
                                color = Color.White
                            )

                        }

                        Image(
                            painter = painterResource(id = currentWeather.weatherType.iconRes),
                            contentDescription = "Weather Icon",
                            modifier = Modifier
                                .width(86.dp)
                                .padding(vertical = 20.dp)
                        )


                    }

                    Image(
                        painter = painterResource(id = currentWeather.weatherType.iconRes),
                        contentDescription = "Weather Icon",
                        modifier = Modifier
                            .width(86.dp)
                            .padding(vertical = 10.dp)
                            .offset(y = -200.dp)
                            .align(Alignment.CenterStart)
                    )
                    Image(
                        painter = painterResource(id = currentWeather.weatherType.iconRes),
                        contentDescription = "Weather Icon",
                        modifier = Modifier
                            .width(86.dp)
                            .padding(vertical = 10.dp)
                            .offset(y = -200.dp)
                            .align(Alignment.CenterEnd)
                    )

                    Image(
                        painter = painterResource(id = currentWeather.weatherType.iconRes),
                        contentDescription = "Weather Icon",
                        modifier = Modifier
                            .width(86.dp)
                            .padding(10.dp)
                            .align(Alignment.CenterStart)
                    )

                    Image(
                        painter = painterResource(id = currentWeather.weatherType.iconRes),
                        contentDescription = "Weather Icon",
                        modifier = Modifier
                            .width(86.dp)
                            .padding(10.dp)
                            .align(Alignment.CenterEnd)
                    )
                }
            }
        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(showBackground = true)
fun WeatherCardPreview() {

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


    val weatherList = listOf(weather)


    var weatherDay: Map<Int, List<Weather>> = mutableMapOf()
    weatherDay = weatherDay.plus(0 to weatherList)
    val weatherInfo = WeatherInfo(weatherDay, weather)
    val weatherViewStates = WeatherViewStates(false, weatherInfo)
    WeatherCard(state = weatherViewStates)
}