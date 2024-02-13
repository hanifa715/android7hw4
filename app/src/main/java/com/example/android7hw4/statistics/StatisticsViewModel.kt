package com.example.android7hw4.statistics

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.android7hw4.data.Repository
import com.example.android7hw4.data.local.Statistics

class StatisticsViewModel : ViewModel() {

    private val repository = Repository()

    fun getStatistic(): LiveData<List<Statistics>> = repository.getStatistic()

    fun deleteStatistic(position: Statistics): LiveData<Unit> = repository.deleteStatistic(position)
}