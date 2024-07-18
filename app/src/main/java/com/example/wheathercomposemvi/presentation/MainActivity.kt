package com.example.wheathercomposemvi.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.wheathercomposemvi.data.network.api.ApiFactory
import com.example.wheathercomposemvi.presentation.ui.theme.WheatherComposeMVI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val apiService = ApiFactory.apiService

        CoroutineScope(Dispatchers.Main).launch {
            val currentWeather = apiService.loadCurrentWeather("London")
            val forecast = apiService.loadForecast("London")
            val cities = apiService.searchCity("London")
            Log.d(
                "MainActivity",
                "Current Weather: $currentWeather\nForecase Weather: $forecast\nCities:$cities"
            )
        }
        setContent {
            WheatherComposeMVI {

            }
        }
    }
}
