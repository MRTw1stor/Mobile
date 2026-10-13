package com.example.myapplication.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.myapplication.features.settings.data.ThemeManager

// ТЕМА 1: Тёмная неоновая схема (Глубокий чёрный вакуум + неоновые вспышки)
private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    secondary = DarkSecondary,
    tertiary = DarkTertiary,
    background = DarkBackground,
    surface = DarkSurface,
    onBackground = DarkOnBackground,
    onSurface = DarkOnSurface
)

// ТЕМА 2: Светлая снежно-белая схема (Идеально чистый фон + строгий контраст)
private val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    secondary = LightSecondary,
    tertiary = LightTertiary,
    background = LightBackground,
    surface = LightSurface,
    onBackground = LightOnBackground,
    onSurface = LightOnSurface
)

// ТЕМА 3: Брендированная Калужская схема (Символика области + Родина Космонавтики)
private val KalugaColorScheme = lightColorScheme(
    primary = KalugaPrimary,            // Изумрудно-зеленый знамени
    onPrimary = Color.White,
    secondary = KalugaSecondary,        // Алый красный акцент
    onSecondary = Color.White,
    tertiary = KalugaTertiary,          // Космический синий
    background = KalugaBackground,      // Серебристо-стальной фон
    surface = KalugaSurface,            // Белые карточки
    onBackground = KalugaOnBackground,
    onSurface = KalugaOnSurface,
    error = KalugaSecondary
)

@Composable
fun MyApplicationTheme(
    themeMode: String = ThemeManager.currentThemeMode,
    content: @Composable () -> Unit
) {
    val colorScheme = when (themeMode) {
        "light" -> LightColorScheme
        "dark" -> DarkColorScheme
        else -> KalugaColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
