package com.example.wheathercomposemvi.data.network.api

import com.example.wheathercomposemvi.data.network.dto.CityDto
import com.example.wheathercomposemvi.data.network.dto.WeatherCurrentDto
import com.example.wheathercomposemvi.data.network.dto.WeatherForecastDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("current.json")
    suspend fun loadCurrentWeather(
        @Query("q") query: String
    ): WeatherCurrentDto //текущая погода

    @GET("forecast.json")
    suspend fun loadForecast(
        @Query("q") query: String,
        @Query("days") daysCount: Int = 4
    ): WeatherForecastDto //прогноз погоды на несколько дней

    @GET("search.json")
    suspend fun searchCity(
        @Query("q") query: String
    ): List<CityDto> //поиск города
}
