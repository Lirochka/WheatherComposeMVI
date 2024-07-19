package com.example.wheathercomposemvi.data.mapper

import com.example.wheathercomposemvi.data.network.dto.CityDto
import com.example.wheathercomposemvi.domain.entity.City

fun CityDto.toEntity(): City = City(id, name, country)

fun List<CityDto>.toEntities(): List<City> = map { it.toEntity() }