package com.example.foodpoint.history_database

import androidx.room.TypeConverter
import com.example.foodpoint.api.food_class.Ingredient
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class IngredientsArrayListConverter {

    var gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): ArrayList<Ingredient> {
        if (data == null) {
            return arrayListOf()
        }
        val listType = object : TypeToken<ArrayList<Ingredient>>() {}.getType()
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(listOfProperdies: ArrayList<Ingredient>): String {
        return gson.toJson(listOfProperdies)
    }

}