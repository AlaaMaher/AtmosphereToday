package com.alaa.atmospheretoday.weather.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alaa.atmospheretoday.weather.domain.model.WeatherType
import com.alaa.atmospheretoday.weather.domain.model.weather.Weather
import com.alaa.atmospheretoday.weather.domain.model.weather.WeatherInfo
import com.alaa.atmospheretoday.weather.presentation.screens.weather_screen.WeatherViewStates
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherForecast(
    state: WeatherViewStates,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.dailyWeatherData?.get(0)?.let { weatherDayData ->
        Card(
            modifier = modifier,
            border = BorderStroke(1.dp, Color.Gray),
            shape = RoundedCornerShape(60.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Black
                    .copy(alpha = 0.1f)
            ),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                                Color.Transparent,
                            ),
                            startY = 300f
                        )
                    )
            ) {
                Column {
                    Row ( modifier = Modifier.fillMaxWidth().padding(top = 25.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ){
                        Text(
                            text = "Hourly Forcast",
                            style = MaterialTheme.typography.displaySmall,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.LightGray
                        )
                        Text(
                            text = "Weekly Forcast",
                            style = MaterialTheme.typography.displaySmall,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.LightGray.copy(alpha = 0.4f)
                        )

                    }


                    Divider(
                        thickness = 0.5.dp,
                        color = Color.Gray,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp)
                    )


                    LazyRow(modifier=Modifier.padding(12.dp),content = {
                        items(weatherDayData) { weatherDay ->
                            HourlyWeatherDisplay(
                                weather = weatherDay,
                                modifier = Modifier
                                    .height(150.dp)
                                    .padding(horizontal = 8.dp)
                            )


                        }
                    })
                    Spacer(modifier = Modifier.height(130.dp))


                }
            }
        }


    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(showBackground = false)
fun WeatherForecastPreview() {

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
    WeatherForecast(state = weatherViewStates)
}