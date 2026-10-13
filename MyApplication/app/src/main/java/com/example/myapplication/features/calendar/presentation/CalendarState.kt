package com.example.myapplication.features.calendar.presentation

import java.time.LocalDate

data class CalendarState(
    val selectedDate: LocalDate = LocalDate.now(),
    val currentEvents: List<String> = emptyList(),
    val isLoading: Boolean = false
)
