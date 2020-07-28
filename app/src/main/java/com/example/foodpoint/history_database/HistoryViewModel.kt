package com.example.foodpoint.history_database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.foodpoint.api.food_class.food_class_to_communicate_wwith_others.SimplyfiFood
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistoryViewModel(application: Application):AndroidViewModel(application) {

    private val repository:HistoryRepository = HistoryRepository(application)
    val allHistory:LiveData<List<SimplyfiFood>>

    init {
        allHistory = repository.allHistory
    }

    fun insertHistory(food: SimplyfiFood) = viewModelScope.launch(Dispatchers.IO){
        repository.insertHistory(food)
    }

    fun deleteHistory(food: SimplyfiFood) = viewModelScope.launch(Dispatchers.IO){
        repository.deleteHistory(food)
    }

    fun deleteAllHistory() = viewModelScope.launch(Dispatchers.IO){
        repository.deleteAllHistory()
    }
}