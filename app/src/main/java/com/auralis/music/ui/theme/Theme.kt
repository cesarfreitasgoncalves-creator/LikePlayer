package com.auralis.music.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val AuralisDarkColors = darkColorScheme(
    primary = Color(0xFF9B6DFF),
    secondary = Color(0xFF7EE7C8),
    tertiary = Color(0xFFB5A4FF),
    background = Color(0xFF09111D),
    surface = Color(0xFF101B2A),
    onBackground = Color.White,
    onSurface = Color.White,
    onPrimary = Color.White
)

private val AuralisLightColors = lightColorScheme(
    primary = Color(0xFF9B6DFF),
    secondary = Color(0xFF7EE7C8),
    tertiary = Color(0xFFB5A4FF),
    background = Color(0xFFF7F3FF),
    surface = Color.White,
    onBackground = Color(0xFF171728),
    onSurface = Color(0xFF171728),
    onPrimary = Color.White
)

@Composable
fun AuralisTheme(darkTheme: Boolean = true, content: @Composable () -> Unit) {
    val colorScheme = if (darkTheme) AuralisDarkColors else AuralisLightColors
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
