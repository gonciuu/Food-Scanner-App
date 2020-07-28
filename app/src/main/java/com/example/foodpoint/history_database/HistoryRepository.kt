package com.example.foodpoint.history_database

import android.app.Application
import com.example.foodpoint.api.food_class.food_class_to_communicate_wwith_others.SimplyfiFood

class HistoryRepository(application: Application) {

    private val historyDao : HistoryDao

    init {
        val database = HistoryDatabase.getInstance(application.applicationContext)
        historyDao = database!!.historyDao()
    }

    suspend fun insertHistory(food: SimplyfiFood){
        historyDao.insertToHistory(food)
    }

    suspend fun deleteHistory(food: SimplyfiFood){
        historyDao.deleteFromHistory(food)
    }

    val allHistory = historyDao.getAllHistory()

    suspend fun deleteAllHistory(){
        historyDao.deleteAllHistory()
    }

}