package com.example.android7hw4.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Statistics::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getDao():StatisticsDao
}