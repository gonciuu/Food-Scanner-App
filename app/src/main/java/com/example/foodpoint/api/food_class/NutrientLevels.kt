package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class NutrientLevels(
    @SerializedName("fat")
    val fat: String,
    @SerializedName("salt")
    val salt: String,
    @SerializedName("saturated-fat")
    val saturatedFat: String,
    @SerializedName("sugars")
    val sugars: String
)