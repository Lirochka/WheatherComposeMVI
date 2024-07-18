package com.example.wheathercomposemvi.domain.usecase

import com.example.wheathercomposemvi.domain.repository.FavouriteRepository
import javax.inject.Inject

class GetFavouriteCitiesUseCase @Inject constructor(
    private val repository: FavouriteRepository
) {

    operator fun invoke() = repository.favouriteCities
}
