package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class Nutrition(
    @SerializedName("display")
    val display: DisplayXX,
    @SerializedName("small")
    val small: SmallXX,
    @SerializedName("thumb")
    val thumb: ThumbXX
)