package com.auralis.music.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private const val SETTINGS_NAME = "auralis_settings"

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = SETTINGS_NAME)

data class AppearanceSettings(
    val darkMode: Boolean = true,
    val accentColorHex: String = "#9b6dff",
    val wallpaperUri: String? = null,
    val cardStyle: String = "Rounded"
)

class SettingsRepository(private val context: Context) {
    private object Keys {
        val darkMode = booleanPreferencesKey("dark_mode")
        val accentColorHex = stringPreferencesKey("accent_color_hex")
        val wallpaperUri = stringPreferencesKey("wallpaper_uri")
        val cardStyle = stringPreferencesKey("card_style")
    }

    val appearanceSettings: Flow<AppearanceSettings> = context.dataStore.data.map { prefs ->
        AppearanceSettings(
            darkMode = prefs[Keys.darkMode] ?: true,
            accentColorHex = prefs[Keys.accentColorHex] ?: "#9b6dff",
            wallpaperUri = prefs[Keys.wallpaperUri],
            cardStyle = prefs[Keys.cardStyle] ?: "Rounded"
        )
    }

    suspend fun setDarkMode(enabled: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[Keys.darkMode] = enabled
        }
    }

    suspend fun setAccentColor(colorHex: String) {
        context.dataStore.edit { prefs ->
            prefs[Keys.accentColorHex] = colorHex
        }
    }

    suspend fun setWallpaperUri(uri: String?) {
        context.dataStore.edit { prefs ->
            if (uri == null) {
                prefs.remove(Keys.wallpaperUri)
            } else {
                prefs[Keys.wallpaperUri] = uri
            }
        }
    }

    suspend fun setCardStyle(style: String) {
        context.dataStore.edit { prefs ->
            prefs[Keys.cardStyle] = style
        }
    }
}
