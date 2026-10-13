package com.example.myapplication.features.settings.presentation

import android.app.Application
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import com.example.myapplication.features.settings.data.ThemeManager
class SettingsViewModel(application: Application) : AndroidViewModel(application) {
    private val context = application.applicationContext
    private val avatarName = "user_avatar.jpg"
    private val _uiState = MutableStateFlow(SettingsState())
    val uiState: StateFlow<SettingsState> = _uiState.asStateFlow()

    init {
        _uiState.update { it.copy(currentTheme = ThemeManager.currentThemeMode) }
        loadAvatar()
    }

    private fun loadAvatar() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoadingAvatar = true) }
            val bitmap = withContext(Dispatchers.IO) {
                runCatching {
                    File(context.filesDir, avatarName).takeIf { it.exists() }?.let { file ->
                        BitmapFactory.decodeFile(file.absolutePath)
                    }
                }.getOrNull()
            }
            _uiState.update { it.copy(avatarBitmap = bitmap, isLoadingAvatar = false) }
        }
    }

    fun saveAvatar(uri: Uri) {
        viewModelScope.launch(Dispatchers.IO) {
            val avatarFile = File(getApplication<Application>().filesDir, "user_avatar.jpg")
            if (avatarFile.exists()) {
                try {
                    val bitmap = BitmapFactory.decodeFile(avatarFile.absolutePath)

                    withContext(Dispatchers.Main) {
                        _uiState.value = _uiState.value.copy(
                            avatarBitmap = bitmap,
                            isLoadingAvatar = false
                        )
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    fun updateTheme(themeMode: String) {
        ThemeManager.updateTheme(context, themeMode)
        _uiState.update { it.copy(currentTheme = themeMode) }
    }
}
