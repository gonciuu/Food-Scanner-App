package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class Sizes(
    @SerializedName("full")
    val full: Full,
    @SerializedName("100")
    val x100: X100,
    @SerializedName("200")
    val x200: X200,
    @SerializedName("400")
    val x400: X400
)