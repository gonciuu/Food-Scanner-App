package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class SizesXXX(
    @SerializedName("full")
    val full: FullXXX,
    @SerializedName("100")
    val x100: X100XXX,
    @SerializedName("200")
    val x200: X200XXX,
    @SerializedName("400")
    val x400: X400XXX
)