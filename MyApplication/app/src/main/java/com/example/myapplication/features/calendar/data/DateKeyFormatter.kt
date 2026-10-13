package com.example.myapplication.features.calendar.data

import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Утилита для генерации единого формата ключей дат (ISO 8601: YYYY-MM-DD).
 */

object DateKeyFormatter {

    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE
    fun getIsoKey(date: LocalDate): String = date.format(formatter)
    fun getIsoKey(year: Int, month: Int, day: Int): String {
        return LocalDate.of(year, month, day).format(formatter)
    }
}
