package com.example.android7hw4

import android.app.Application
import androidx.room.Room
import com.example.android7hw4.data.local.AppDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "database-name"
        ).allowMainThreadQueries().build()
    }

    companion object {
        lateinit var db: AppDatabase
    }
}