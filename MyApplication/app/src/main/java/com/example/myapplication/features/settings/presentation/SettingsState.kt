package com.example.myapplication.features.settings.presentation

import android.graphics.Bitmap

data class SettingsState(
    val avatarBitmap: Bitmap? = null,
    val currentTheme: String = "system",
    val isLoadingAvatar: Boolean = false
)
