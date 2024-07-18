package com.example.wheathercomposemvi.domain.repository

import com.example.wheathercomposemvi.domain.entity.City

interface SearchRepository {

    suspend fun search(query: String): List<City>
}
