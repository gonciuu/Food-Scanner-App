package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class Front(
    @SerializedName("display")
    val display: Display,
    @SerializedName("small")
    val small: Small,
    @SerializedName("thumb")
    val thumb: Thumb
)