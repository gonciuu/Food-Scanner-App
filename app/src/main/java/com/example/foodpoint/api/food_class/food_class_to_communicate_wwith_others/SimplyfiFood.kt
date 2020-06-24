package com.example.foodpoint.api.food_class.food_class_to_communicate_wwith_others

class SimplyfiFood(
    val name: String,
    val calories: Int,
    val carbohydrates: Double,
    val proteins: Double,
    val fats: Double,
    val isVegetarian: Boolean,
    val isVegan: Boolean,
    val nutrients: ArrayList<String>,
    val categories : ArrayList<String>,
    val allergens : ArrayList<String>
)