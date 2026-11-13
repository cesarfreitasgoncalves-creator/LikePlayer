package com.auralis.music.data

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "playlists")
data class PlaylistEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val description: String = "",
    val trackIds: List<Long> = emptyList()
)

class PlaylistTypeConverters {
    @TypeConverter
    fun fromList(value: List<Long>): String = value.joinToString(",")

    @TypeConverter
    fun toList(value: String): List<Long> = if (value.isBlank()) emptyList() else value.split(",").mapNotNull { it.toLongOrNull() }
}

@Dao
interface PlaylistDao {
    fun getAllPlaylists(): Flow<List<PlaylistEntity>>

    suspend fun insert(playlist: PlaylistEntity)

    suspend fun update(playlist: PlaylistEntity)

    suspend fun delete(playlist: PlaylistEntity)
}
