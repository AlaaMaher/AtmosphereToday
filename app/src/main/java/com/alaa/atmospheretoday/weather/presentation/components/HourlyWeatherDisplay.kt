package com.alaa.atmospheretoday.weather.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alaa.atmospheretoday.weather.domain.model.WeatherType
import com.alaa.atmospheretoday.weather.domain.model.weather.Weather
import com.alaa.atmospheretoday.weather.domain.model.weather.WeatherInfo
import com.alaa.atmospheretoday.weather.presentation.screens.weather_screen.WeatherViewStates
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HourlyWeatherDisplay(
    weather: Weather,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White
) {
    val timeFormatted = remember(weather) {
        weather.time.format(DateTimeFormatter.ofPattern("H:a"))
    }
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(35.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 15.dp, horizontal = 5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(text = timeFormatted, color = Color.Gray, fontSize = 14.sp)
            Image(
                painter = painterResource(id = weather.weatherType.iconRes),
                contentDescription = null,
                modifier = Modifier.width(40.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = weather.temperatureInCelsius,
                color = textColor,
                fontWeight = FontWeight.Bold
            )


        }

    }
}

