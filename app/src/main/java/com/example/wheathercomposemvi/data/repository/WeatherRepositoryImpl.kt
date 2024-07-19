package com.example.wheathercomposemvi.data.repository

import com.example.wheathercomposemvi.data.mapper.toEntity
import com.example.wheathercomposemvi.data.network.api.ApiService
import com.example.wheathercomposemvi.domain.entity.Forecast
import com.example.wheathercomposemvi.domain.entity.Weather
import com.example.wheathercomposemvi.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : WeatherRepository {

    override suspend fun getWeather(cityId: Int): Weather {
        return apiService.loadCurrentWeather("$PREFIX_CITY_ID$cityId").toEntity()
    }

    override suspend fun getForecast(cityId: Int): Forecast {
        return apiService.loadForecast("$PREFIX_CITY_ID$cityId").toEntity()
    }

    private companion object {

        private const val PREFIX_CITY_ID = "id:"
    }
}