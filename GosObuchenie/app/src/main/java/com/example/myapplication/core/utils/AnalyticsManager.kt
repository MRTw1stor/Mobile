package com.example.myapplication.core.utils

import io.appmetrica.analytics.AppMetrica

object AnalyticsManager {

    fun trackLinkClick(linkName: String, url: String) {
        val eventParameters = mapOf(
            "name" to linkName,
            "url" to url
        )
        AppMetrica.reportEvent("click_link", eventParameters)
        AppMetrica.sendEventsBuffer()
    }
}