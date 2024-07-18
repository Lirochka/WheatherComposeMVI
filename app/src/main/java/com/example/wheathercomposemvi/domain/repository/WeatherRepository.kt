package com.example.wheathercomposemvi.domain.repository

import com.example.wheathercomposemvi.domain.entity.Forecast
import com.example.wheathercomposemvi.domain.entity.Weather

interface WeatherRepository {

    suspend fun getWeather(cityId: Int): Weather

    suspend fun getForecast(cityId: Int): Forecast
}
