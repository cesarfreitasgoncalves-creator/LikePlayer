package com.auralis.music

import android.app.Application
import com.auralis.music.data.AppDatabase

class AuralisApplication : Application() {
    lateinit var database: AppDatabase
        private set

    override fun onCreate() {
        super.onCreate()
        database = AppDatabase.getInstance(this)
    }
}
