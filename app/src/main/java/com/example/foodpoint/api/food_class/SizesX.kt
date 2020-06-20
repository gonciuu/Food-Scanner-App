package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class SizesX(
    @SerializedName("full")
    val full: FullX,
    @SerializedName("100")
    val x100: X100X,
    @SerializedName("200")
    val x200: X200X,
    @SerializedName("400")
    val x400: X400X
)