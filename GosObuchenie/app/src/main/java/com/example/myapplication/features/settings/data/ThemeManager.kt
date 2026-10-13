package com.example.myapplication.features.settings.data

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

object ThemeManager {
    var currentThemeMode by mutableStateOf("system")
        private set

    fun initialize(context: Context) {
        val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        currentThemeMode = prefs.getString("theme_mode", "system") ?: "system"
    }

    fun updateTheme(context: Context, mode: String) {
        currentThemeMode = mode
        val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        prefs.edit().putString("theme_mode", mode).apply()
    }
}