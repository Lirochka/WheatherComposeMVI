package com.example.wheathercomposemvi.data.mapper

import com.example.wheathercomposemvi.data.local.model.CityDbModel
import com.example.wheathercomposemvi.domain.entity.City

fun City.toDbModel(): CityDbModel = CityDbModel(id, name, country)

fun CityDbModel.toEntity(): City = City(id, name, country)

fun List<CityDbModel>.toEntities(): List<City> = map { it.toEntity() }