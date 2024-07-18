package com.example.wheathercomposemvi.data.network.dto

import com.example.wheathercomposemvi.data.network.dto.ConditionDto
import com.google.gson.annotations.SerializedName

data class DayWeatherDto(
    @SerializedName("avgtemp_c") val tempC: Float,
    @SerializedName("condition") val conditionDto: ConditionDto
)
