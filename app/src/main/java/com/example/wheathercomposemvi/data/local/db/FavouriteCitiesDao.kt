package com.example.wheathercomposemvi.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.wheathercomposemvi.data.local.model.CityDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteCitiesDao {

    //все избранные фильмы из базы
    @Query("SELECT * FROM favourite_cities")
    fun getFavouriteCities(): Flow<List<CityDbModel>>

    //присутствовает объект в базе данных или нет.
    //Получить надо только один объект поэтому LIMIT 1
    @Query("SELECT EXISTS (SELECT * FROM favourite_cities WHERE id=:cityId LIMIT 1)")
    fun observeIsFavourite(cityId: Int): Flow<Boolean>

    //добавляет город в избранное
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavourite(cityDbModel: CityDbModel)

    //удаляет фильм из базы
    @Query("DELETE FROM favourite_cities WHERE id=:cityId")
    suspend fun removeFromFavourite(cityId: Int)
}