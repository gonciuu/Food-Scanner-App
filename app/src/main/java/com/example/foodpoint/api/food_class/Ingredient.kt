package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class Ingredient(
    @SerializedName("id")
    val id: String,
    @SerializedName("percent")
    val percent: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("text")
    val text: String,
    @SerializedName("vegan")
    val vegan: String,
    @SerializedName("vegetarian")
    val vegetarian: String
)