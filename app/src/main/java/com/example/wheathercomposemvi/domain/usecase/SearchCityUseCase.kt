package com.example.wheathercomposemvi.domain.usecase

import com.example.wheathercomposemvi.domain.repository.SearchRepository
import javax.inject.Inject

class SearchCityUseCase @Inject constructor(
    private val repository: SearchRepository
) {

    suspend operator fun invoke(query: String) = repository.search(query)
}
