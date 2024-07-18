package com.example.wheathercomposemvi.data.network.dto

import com.example.wheathercomposemvi.data.network.dto.ForecastDto
import com.example.wheathercomposemvi.data.network.dto.WeatherDto
import com.google.gson.annotations.SerializedName

data class WeatherForecastDto(
    @SerializedName("current") val current: WeatherDto,
    @SerializedName("forecast") val forecastDto: ForecastDto
)
