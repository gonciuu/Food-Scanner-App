package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class FullXX(
    @SerializedName("h")
    val h: Int,
    @SerializedName("w")
    val w: Int
)