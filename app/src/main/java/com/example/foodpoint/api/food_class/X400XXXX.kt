package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class X400XXXX(
    @SerializedName("h")
    val h: Int,
    @SerializedName("w")
    val w: Int
)