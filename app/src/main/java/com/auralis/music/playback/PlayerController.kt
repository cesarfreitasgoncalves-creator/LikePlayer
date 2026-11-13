package com.auralis.music.playback

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.auralis.music.data.AudioTrack

class PlayerController(context: Context) : AutoCloseable {
    private val player: ExoPlayer = ExoPlayer.Builder(context).build()
    private var queue: List<AudioTrack> = emptyList()
    private var currentIndex: Int = -1

    val isPlaying: Boolean
        get() = player.isPlaying

    fun setQueue(tracks: List<AudioTrack>, startIndex: Int = 0) {
        queue = tracks
        if (tracks.isEmpty()) return
        currentIndex = startIndex.coerceIn(0, tracks.lastIndex)
        player.setMediaItem(MediaItem.fromUri(tracks[currentIndex].uri))
        player.prepare()
    }

    fun playTrack(track: AudioTrack) {
        queue = listOf(track)
        currentIndex = 0
        player.setMediaItem(MediaItem.fromUri(track.uri))
        player.prepare()
        player.play()
    }

    fun play() = player.play()
    fun pause() = player.pause()
    fun togglePlayPause() = if (player.isPlaying) player.pause() else player.play()
    fun seekTo(positionMs: Long) = player.seekTo(positionMs)

    fun next() {
        if (queue.isEmpty()) return
        currentIndex = ((currentIndex + 1) % queue.size).coerceIn(0, queue.lastIndex)
        player.setMediaItem(MediaItem.fromUri(queue[currentIndex].uri))
        player.prepare()
        player.play()
    }

    fun previous() {
        if (queue.isEmpty()) return
        currentIndex = ((currentIndex - 1 + queue.size) % queue.size).coerceIn(0, queue.lastIndex)
        player.setMediaItem(MediaItem.fromUri(queue[currentIndex].uri))
        player.prepare()
        player.play()
    }

    fun currentTrack(): AudioTrack? = queue.getOrNull(currentIndex)

    fun addListener(listener: Player.Listener) {
        player.addListener(listener)
    }

    fun removeListener(listener: Player.Listener) {
        player.removeListener(listener)
    }

    override fun close() {
        player.release()
    }
}
