package com.example.foodpoint.api.food_class.food_class_to_communicate_wwith_others

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foodpoint.api.food_class.Ingredient

@Entity(tableName = "history_database")
data class SimplyfiFood(
    val urlId:String,
    val name: String,
    val quantity:Int,
    val imageUrl:String,
    val calories: Int,
    val carbohydrates: Double,
    val proteins: Double,
    val fats: Double,
    val ingredients: ArrayList<Ingredient>,
    val categories : ArrayList<String>,
    val allergens : ArrayList<String>
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}