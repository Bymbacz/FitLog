package com.example.fitlog.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Nowoczesna paleta Dark Mode
val DarkBackground = Color(0xFF0D1117)      // Głęboki grafit (tło główne)
val DarkSurface = Color(0xFF161B22)         // Karty i dolny pasek
val DarkSurfaceVariant = Color(0xFF21262D)  // Pola formularzy, chipy
val AccentMint = Color(0xFF2EE59D)          // Główny akcent (progres, CTA)
val AccentBlue = Color(0xFF58A6FF)          // Akcent pomocniczy (woda, basen)
val TextPrimary = Color(0xFFF0F6FC)
val TextSecondary = Color(0xFF8B949E)
val DangerRed = Color(0xFFFF6B6B)

private val AppDarkColorScheme = darkColorScheme(
    primary = AccentMint,
    onPrimary = Color(0xFF062016),
    secondary = AccentBlue,
    onSecondary = Color(0xFF05192D),
    background = DarkBackground,
    onBackground = TextPrimary,
    surface = DarkSurface,
    onSurface = TextPrimary,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = TextSecondary,
    error = DangerRed
)

@Composable
fun FitLogMDTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = AppDarkColorScheme,
        content = content
    )
}