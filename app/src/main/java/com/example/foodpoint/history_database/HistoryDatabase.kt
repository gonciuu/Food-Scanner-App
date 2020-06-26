package com.example.foodpoint.history_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.foodpoint.api.food_class.food_class_to_communicate_wwith_others.SimplyfiFood

@Database(entities = [SimplyfiFood::class], version = 2)
@TypeConverters(StringArrayListConverter::class,IngredientsArrayListConverter::class)
abstract class HistoryDatabase : RoomDatabase() {

    abstract fun historyDao(): HistoryDao

    companion object {
        var instance: HistoryDatabase? = null

        fun getInstance(context: Context): HistoryDatabase? {
            if (instance == null) instance =
                Room.databaseBuilder(context, HistoryDatabase::class.java, "history_database")
                    .fallbackToDestructiveMigration().build()
            return instance
        }

    }


}