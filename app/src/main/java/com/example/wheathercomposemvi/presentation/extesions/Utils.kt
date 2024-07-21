package com.example.wheathercomposemvi.presentation.extesions

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnDestroy
import kotlin.math.roundToInt
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

fun ComponentContext.componentScope() = CoroutineScope(
    Dispatchers.Main.immediate + SupervisorJob()
).apply {
    lifecycle.doOnDestroy { cancel() }
}

fun Float.tempToFormattedString(): String = "${roundToInt()}°C"

fun Calendar.formattedFullDate(): String {
    val format = SimpleDateFormat("EEEE | d MMM y", Locale.getDefault())
    return format.format(time)
}

fun Calendar.formattedShortDayOfWeek(): String {
    val format = SimpleDateFormat("EEE", Locale.getDefault())
    return format.format(time)
}