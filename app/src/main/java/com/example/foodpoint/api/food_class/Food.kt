package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class Food(
    @SerializedName("code")
    val code: String,
    @SerializedName("product")
    val product: Product,
    @SerializedName("status")
    val status: Int,
    @SerializedName("status_verbose")
    val statusVerbose: String
)