package com.example.myapplication

import android.app.Application
import io.appmetrica.analytics.AppMetrica
import io.appmetrica.analytics.AppMetricaConfig

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        try {
            val apiKey = BuildConfig.APPMETRICA_API_KEY
            if (apiKey.isBlank()) return

            val config = AppMetricaConfig.newConfigBuilder(apiKey)
                .withLogs()
                .build()

            AppMetrica.activate(applicationContext, config)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
