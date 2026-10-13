package com.example.myapplication.core.security

import android.content.Context
import android.content.SharedPreferences

/**
 * Менеджер локального хранилища приложения.
 * Отвечает за хранение настроек, аватара и данных календаря.
 */
object PreferenceManager {

    private const val PREFS_FILE_NAME = "app_local_prefs"
    @Volatile
    private var sharedPreferences: SharedPreferences? = null

    /**
     * Потокобезопасное получение обычных SharedPreferences
     */
    fun getPrefs(context: Context): SharedPreferences {
        return sharedPreferences ?: synchronized(this) {
            sharedPreferences ?: context.applicationContext
                .getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .also { sharedPreferences = it }
        }
    }

    /**
     * Получение URI сохраненного локального аватара
     */
    fun getUserAvatarUri(context: Context): String? {
        return getPrefs(context).getString("user_avatar_uri", null)
    }

    /**
     * Обновление пути к аватарке пользователя
     */
    fun updateAvatarUri(context: Context, avatarUri: String?): Boolean {
        getPrefs(context).edit().apply {
            putString("user_avatar_uri", avatarUri)
            apply()
        }
        return true
    }
}
