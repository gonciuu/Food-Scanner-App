package com.example.foodpoint.history_database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StringArrayListConverter {

        var gson = Gson()

        @TypeConverter
        fun stringToSomeObjectList(data: String?): ArrayList<String> {
            if (data == null) {
                return arrayListOf()
            }
            val listType = object : TypeToken<ArrayList<String>>() {}.getType()
            return gson.fromJson(data, listType)
        }

        @TypeConverter
        fun someObjectListToString(listOfProperdies: ArrayList<String>): String {
            return gson.toJson(listOfProperdies)
        }

}