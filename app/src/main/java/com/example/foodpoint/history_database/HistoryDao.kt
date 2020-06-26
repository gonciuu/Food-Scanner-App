package com.example.foodpoint.history_database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.foodpoint.api.food_class.food_class_to_communicate_wwith_others.SimplyfiFood


@Dao
interface HistoryDao {

    @Insert
    suspend fun insertToHistory(food: SimplyfiFood)

    @Delete
    suspend fun deleteFromHistory(food: SimplyfiFood)

    @Query("SELECT * FROM history_database ORDER BY id")
    fun getAllHistory():LiveData<List<SimplyfiFood>>

}