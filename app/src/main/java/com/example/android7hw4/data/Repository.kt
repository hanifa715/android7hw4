package com.example.android7hw4.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.android7hw4.App
import com.example.android7hw4.data.local.Statistics
import kotlinx.coroutines.Dispatchers

class Repository {

    fun addStatistic(model: Statistics): LiveData<Long> = liveData(Dispatchers.IO) {
        val insertedId = App.db.getDao().insert(model)
        emit(insertedId)
    }


    fun getStatistic(): LiveData<List<Statistics>> = liveData(Dispatchers.Main) {
        emit(App.db.getDao().getAll())
    }

    fun deleteStatistic(position:Statistics): LiveData<Unit> = liveData(Dispatchers.Main) {
        emit(App.db.getDao().delete(position))
    }
}