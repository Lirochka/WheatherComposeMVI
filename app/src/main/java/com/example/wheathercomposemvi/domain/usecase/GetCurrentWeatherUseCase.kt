package com.example.wheathercomposemvi.domain.usecase

import com.example.wheathercomposemvi.domain.repository.WeatherRepository
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(cityId: Int) = repository.getWeather(cityId)
}
