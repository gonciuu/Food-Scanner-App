package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class Ingredient(
    @SerializedName("has_sub_ingredients")
    val hasSubIngredients: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("percent_max")
    val percentMax: Double,
    @SerializedName("percent_min")
    val percentMin: Double,
    @SerializedName("processing")
    val processing: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("text")
    val text: String,
    @SerializedName("vegan")
    val vegan: String,
    @SerializedName("vegetarian")
    val vegetarian: String
)