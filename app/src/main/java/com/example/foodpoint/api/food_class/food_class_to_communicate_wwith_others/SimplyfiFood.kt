package com.example.foodpoint.api.food_class.food_class_to_communicate_wwith_others

import com.example.foodpoint.api.food_class.Ingredient

class SimplyfiFood(
    val name: String,
    val calories: Int,
    val carbohydrates: Double,
    val proteins: Double,
    val fats: Double,
    val ingredients: ArrayList<Ingredient>,
    val categories : ArrayList<String>,
    val allergens : ArrayList<String>
)