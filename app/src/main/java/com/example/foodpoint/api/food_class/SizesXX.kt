package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class SizesXX(
    @SerializedName("full")
    val full: FullXX,
    @SerializedName("100")
    val x100: X100XX,
    @SerializedName("200")
    val x200: X200XX,
    @SerializedName("400")
    val x400: X400XX
)