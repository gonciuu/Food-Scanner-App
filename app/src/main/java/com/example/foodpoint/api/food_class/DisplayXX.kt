package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class DisplayXX(
    @SerializedName("fr")
    val fr: String,
    @SerializedName("pl")
    val pl: String
)