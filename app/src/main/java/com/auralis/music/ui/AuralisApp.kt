package com.auralis.music.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.filled.Stats
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.auralis.music.data.AudioTrack
import com.auralis.music.viewmodel.AuralisUiState
import com.auralis.music.viewmodel.AuralisViewModel

@Composable
fun AuralisApp(viewModel: AuralisViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    val navItems = listOf(
        NavItem("Home", Icons.Filled.Home),
        NavItem("Library", Icons.Filled.LibraryMusic),
        NavItem("Search", Icons.Filled.Search),
        NavItem("Stats", Icons.Filled.Stats),
        NavItem("Profile", Icons.Filled.Person)
    )

    Scaffold(
        bottomBar = {
            BottomAppBar(containerColor = MaterialTheme.colorScheme.surface) {
                navItems.forEach { item ->
                    NavigationBarItem(
                        selected = item.label == "Home",
                        onClick = { },
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) },
                        alwaysShowLabel = false,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                        )
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            HomeScreen(uiState = uiState, onTrackClick = viewModel::onTrackSelected, onTogglePlay = viewModel::togglePlayback)
            if (uiState.currentTrack != null) {
                MiniPlayer(
                    track = uiState.currentTrack,
                    playing = uiState.isPlaying,
                    onPlayPause = viewModel::togglePlayback,
                    onNext = viewModel::playNext,
                    onPrevious = viewModel::playPrevious,
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }
        }
    }
}

@Composable
private fun HomeScreen(
    uiState: AuralisUiState,
    onTrackClick: (AudioTrack) -> Unit,
    onTogglePlay: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Good evening", color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f), fontSize = 15.sp)
                    Text("Auralis", fontSize = 28.sp, fontWeight = FontWeight.Bold)
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Settings, contentDescription = "Settings")
                }
            }
        }

        item {
            Card(shape = RoundedCornerShape(24.dp), modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("Now playing", color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f), fontSize = 13.sp)
                        Text(uiState.currentTrack?.title ?: "No track selected", fontWeight = FontWeight.SemiBold)
                        Text(uiState.currentTrack?.artist ?: "Select a song to start listening", fontSize = 12.sp)
                    }
                    IconButton(onClick = onTogglePlay) {
                        Icon(Icons.Filled.PlayArrow, contentDescription = "Play / Pause")
                    }
                }
            }
        }

        item {
            Text("Quick access", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }

        item {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(listOf("Library", "Favorites", "Playlists", "Queue")) { item ->
                    Card(
                        shape = RoundedCornerShape(18.dp),
                        modifier = Modifier.clickable { }
                    ) {
                        Box(
                            modifier = Modifier.padding(horizontal = 18.dp, vertical = 12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(item)
                        }
                    }
                }
            }
        }

        item {
            Text("Your library", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }

        if (uiState.isLoading) {
            item {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
        } else {
            items(uiState.songs.take(6)) { track ->
                SongRow(track = track, onTrackClick = onTrackClick)
            }
        }
    }
}

@Composable
private fun SongRow(track: AudioTrack, onTrackClick: (AudioTrack) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .clickable { onTrackClick(track) }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f), RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Filled.LibraryMusic, contentDescription = null)
            }
            Spacer(modifier = Modifier.size(12.dp))
            Column {
                Text(track.title, fontWeight = FontWeight.Medium)
                Text(track.artist, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f), fontSize = 12.sp)
            }
        }
        Text("${track.durationMs / 60000}m")
    }
}

@Composable
private fun MiniPlayer(
    track: AudioTrack,
    playing: Boolean,
    onPlayPause: () -> Unit,
    onNext: () -> Unit,
    onPrevious: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(track.title, fontWeight = FontWeight.SemiBold)
                Text(track.artist, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f))
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onPrevious) { Icon(Icons.Filled.SkipPrevious, contentDescription = "Previous") }
                IconButton(onClick = onPlayPause) { Icon(Icons.Filled.PlayArrow, contentDescription = "Play") }
                IconButton(onClick = onNext) { Icon(Icons.Filled.SkipNext, contentDescription = "Next") }
            }
        }
    }
}

private data class NavItem(
    val label: String,
    val icon: ImageVector
)
