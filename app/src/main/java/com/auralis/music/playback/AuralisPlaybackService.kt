package com.auralis.music.playback

import android.app.Notification
import android.content.Intent
import androidx.media3.common.AudioAttributes
import androidx.media3.common.C
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.session.MediaSession
import androidx.media3.session.MediaSessionService

class AuralisPlaybackService : MediaSessionService() {
    private var mediaSession: MediaSession? = null
    private var exoPlayer: ExoPlayer? = null

    override fun onCreate() {
        super.onCreate()
        exoPlayer = ExoPlayer.Builder(this).build().also { player ->
            player.setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(C.AUDIO_CONTENT_TYPE_MUSIC)
                    .setUsage(C.USAGE_MEDIA)
                    .build(),
                true
            )
        }

        mediaSession = MediaSession.Builder(this, exoPlayer!!).build()
    }

    override fun onGetSession(controllerInfo: MediaSession.ControllerInfo): MediaSession? = mediaSession

    override fun onDestroy() {
        mediaSession?.release()
        exoPlayer?.release()
        super.onDestroy()
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        stopSelf()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    override fun onUpdateNotification(session: MediaSession, startInForeground: Boolean) {
        val notification = Notification.Builder(this, "auralis_channel")
            .setSmallIcon(android.R.drawable.stat_notify_music_no_art)
            .setContentTitle("Auralis Music")
            .setContentText("Playing audio in the background")
            .setPriority(Notification.PRIORITY_LOW)
            .build()
        startForeground(1, notification)
    }
}
