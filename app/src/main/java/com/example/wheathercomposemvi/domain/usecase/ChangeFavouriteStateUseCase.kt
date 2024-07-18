package com.example.wheathercomposemvi.domain.usecase

import com.example.wheathercomposemvi.domain.entity.City
import com.example.wheathercomposemvi.domain.repository.FavouriteRepository
import javax.inject.Inject

class ChangeFavouriteStateUseCase @Inject constructor(
    private val repository: FavouriteRepository
) {

    suspend fun addToFavourite(city: City) = repository.addToFavourite(city)
    suspend fun removeFromFavourite(cityId: Int) = repository.removeFromFavourite(cityId)
}
