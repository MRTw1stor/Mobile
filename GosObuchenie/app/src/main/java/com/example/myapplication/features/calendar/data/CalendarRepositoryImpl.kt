package com.example.myapplication.features.calendar.data

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import com.example.myapplication.core.security.PreferenceManager

/**
 * Реализация репозитория событий календаря на базе SharedPreferences.
 */
class CalendarRepositoryImpl(context: Context) : CalendarRepository {

    private val appContext = context.applicationContext

    override suspend fun getEventsForDate(dateKey: String): List<String> = withContext(Dispatchers.IO) {
        try {
            val jsonString = PreferenceManager.getPrefs(appContext).getString("calendar_events_$dateKey", null)
                ?: return@withContext emptyList()
            val jsonArray = JSONArray(jsonString)
            List(jsonArray.length()) { jsonArray.getString(it) }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    override suspend fun addEventForDate(dateKey: String, eventText: String): Boolean = withContext(Dispatchers.IO) {
        try {
            val currentEvents = getEventsForDate(dateKey).toMutableList()
            if (currentEvents.size >= 3) return@withContext false

            currentEvents.add(eventText)
            PreferenceManager.getPrefs(appContext).edit()
                .putString("calendar_events_$dateKey", JSONArray(currentEvents).toString())
                .apply()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    override suspend fun deleteEventForDate(dateKey: String, index: Int): Unit = withContext(Dispatchers.IO) {
        try {
            val currentEvents = getEventsForDate(dateKey).toMutableList()
            if (index in currentEvents.indices) {
                currentEvents.removeAt(index)
                val prefs = PreferenceManager.getPrefs(appContext)
                if (currentEvents.isEmpty()) {
                    prefs.edit().remove("calendar_events_$dateKey").apply()
                } else {
                    prefs.edit().putString("calendar_events_$dateKey", JSONArray(currentEvents).toString()).apply()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
