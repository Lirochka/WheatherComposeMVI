package com.example.wheathercomposemvi.di

import android.content.Context
import com.example.wheathercomposemvi.data.local.db.FavouriteCitiesDao
import com.example.wheathercomposemvi.data.local.db.FavouriteDatabase
import com.example.wheathercomposemvi.data.network.api.ApiFactory
import com.example.wheathercomposemvi.data.network.api.ApiService
import com.example.wheathercomposemvi.data.repository.FavouriteRepositoryImpl
import com.example.wheathercomposemvi.data.repository.SearchRepositoryImpl
import com.example.wheathercomposemvi.data.repository.WeatherRepositoryImpl
import com.example.wheathercomposemvi.domain.repository.FavouriteRepository
import com.example.wheathercomposemvi.domain.repository.SearchRepository
import com.example.wheathercomposemvi.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface DataModule {

    @[ApplicationScope Binds]
    fun bindFavouriteRepository(impl: FavouriteRepositoryImpl): FavouriteRepository

    @[ApplicationScope Binds]
    fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository

    @[ApplicationScope Binds]
    fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository

    companion object {

        @[ApplicationScope Provides]
        fun provideApiService(): ApiService = ApiFactory.apiService

        @[ApplicationScope Provides]
        fun provideFavouriteDatabase(context: Context): FavouriteDatabase {
            return FavouriteDatabase.getInstance(context)
        }

        @[ApplicationScope Provides]
        fun provideFavouriteCitiesDao(database: FavouriteDatabase): FavouriteCitiesDao {
            return database.favouriteCitiesDao()
        }
    }
}