package com.example.myapplication.features.calendar.data

interface CalendarRepository {
    suspend fun getEventsForDate(dateKey: String): List<String>
    suspend fun addEventForDate(dateKey: String, eventText: String): Boolean
    suspend fun updateEventForDate(dateKey: String, index: Int, eventText: String): Boolean
    suspend fun deleteEventForDate(dateKey: String, index: Int)
}
