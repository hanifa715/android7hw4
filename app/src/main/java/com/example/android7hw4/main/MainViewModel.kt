package com.example.android7hw4.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.android7hw4.data.Repository
import com.example.android7hw4.data.local.Statistics

class MainViewModel : ViewModel() {

    private val repository = Repository()

    fun addStatistic(model: Statistics): LiveData<Long> = repository.addStatistic(model)
}