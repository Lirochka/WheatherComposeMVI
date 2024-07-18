package com.example.wheathercomposemvi.data.network.dto

import com.example.wheathercomposemvi.data.network.dto.DayDto
import com.google.gson.annotations.SerializedName

data class ForecastDto(
    @SerializedName("forecastday") val forecastDay: List<DayDto>
)
