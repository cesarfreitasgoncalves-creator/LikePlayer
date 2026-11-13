package com.auralis.music.viewmodel

import android.app.Application
import androidx.compose.runtime.Stable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.auralis.music.data.AppearanceSettings
import com.auralis.music.data.AudioTrack
import com.auralis.music.data.LocalMusicRepository
import com.auralis.music.data.SettingsRepository
import com.auralis.music.playback.PlayerController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@Stable
data class AuralisUiState(
    val songs: List<AudioTrack> = emptyList(),
    val currentTrack: AudioTrack? = null,
    val isPlaying: Boolean = false,
    val isLoading: Boolean = false,
    val appearance: AppearanceSettings = AppearanceSettings(),
    val searchQuery: String = "",
    val playlists: List<String> = listOf("Favourites", "Recently played", "Night drive")
)

class AuralisViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = LocalMusicRepository(application)
    private val settingsRepository = SettingsRepository(application)
    private val playerController = PlayerController(application)

    private val _uiState = MutableStateFlow(AuralisUiState())
    val uiState: StateFlow<AuralisUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            settingsRepository.appearanceSettings.collect { settings ->
                _uiState.update { it.copy(appearance = settings) }
            }
        }
    }

    fun loadLocalLibrary() {
        _uiState.update { it.copy(isLoading = true) }
        val songs = repository.loadSongs()
        _uiState.update { it.copy(songs = songs, isLoading = false) }
    }

    fun onSearchChanged(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun onTrackSelected(track: AudioTrack) {
        playerController.playTrack(track)
        _uiState.update { it.copy(currentTrack = track, isPlaying = true) }
    }

    fun togglePlayback() {
        val currentTrack = _uiState.value.currentTrack
        if (currentTrack == null && _uiState.value.songs.isNotEmpty()) {
            onTrackSelected(_uiState.value.songs.first())
            return
        }
        playerController.togglePlayPause()
        _uiState.update { it.copy(isPlaying = !it.isPlaying) }
    }

    fun setDarkMode(enabled: Boolean) {
        viewModelScope.launch { settingsRepository.setDarkMode(enabled) }
    }

    fun setAccentColor(hex: String) {
        viewModelScope.launch { settingsRepository.setAccentColor(hex) }
    }

    fun setWallpaperUri(uri: String?) {
        viewModelScope.launch { settingsRepository.setWallpaperUri(uri) }
    }

    fun setCardStyle(style: String) {
        viewModelScope.launch { settingsRepository.setCardStyle(style) }
    }

    fun playNext() {
        playerController.next()
        _uiState.update { it.copy(currentTrack = playerController.currentTrack(), isPlaying = true) }
    }

    fun playPrevious() {
        playerController.previous()
        _uiState.update { it.copy(currentTrack = playerController.currentTrack(), isPlaying = true) }
    }

    fun seek(positionMs: Long) {
        playerController.seekTo(positionMs)
    }

    override fun onCleared() {
        super.onCleared()
        playerController.close()
    }
}
