package com.example.android7hw4.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StatisticsDao {

    @Query("SELECT * FROM statistics")
    fun getAll():List<Statistics>

    @Insert
    fun insert(model:Statistics):Long

    @Delete
    fun delete(model: Statistics)
}