package com.example.wheathercomposemvi.data.repository

import com.example.wheathercomposemvi.data.local.db.FavouriteCitiesDao
import com.example.wheathercomposemvi.data.mapper.toDbModel
import com.example.wheathercomposemvi.data.mapper.toEntities
import com.example.wheathercomposemvi.domain.entity.City
import com.example.wheathercomposemvi.domain.repository.FavouriteRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavouriteRepositoryImpl @Inject constructor(
    private val favouriteCitiesDao: FavouriteCitiesDao,
) : FavouriteRepository {

    override val favouriteCities: Flow<List<City>> = favouriteCitiesDao.getFavouriteCities()
        .map { it.toEntities() }

    override fun observeIsFavourite(cityId: Int): Flow<Boolean> = favouriteCitiesDao
        .observeIsFavourite(cityId)

    override suspend fun addToFavourite(city: City) = favouriteCitiesDao
        .addToFavourite(city.toDbModel())

    override suspend fun removeFromFavourite(cityId: Int) = favouriteCitiesDao
        .removeFromFavourite(cityId)
}