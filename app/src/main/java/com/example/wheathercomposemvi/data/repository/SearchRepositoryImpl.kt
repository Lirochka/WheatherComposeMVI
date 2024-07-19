package com.example.wheathercomposemvi.data.repository

import com.example.wheathercomposemvi.data.mapper.toEntities
import com.example.wheathercomposemvi.data.network.api.ApiService
import com.example.wheathercomposemvi.domain.entity.City
import com.example.wheathercomposemvi.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : SearchRepository {

    override suspend fun search(query: String): List<City> {
        return apiService.searchCity(query).toEntities()
    }
}