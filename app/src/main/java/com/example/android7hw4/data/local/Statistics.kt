package com.example.android7hw4.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "statistics")
data class Statistics(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val status: String? = null,
    val difficulty: String? = null,
    val mistakes: String? = null,
    val result: String? = null,
) : Serializable