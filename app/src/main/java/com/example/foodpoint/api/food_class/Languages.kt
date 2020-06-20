package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class Languages(
    @SerializedName("en:french")
    val enFrench: Int,
    @SerializedName("en:german")
    val enGerman: Int,
    @SerializedName("en:polish")
    val enPolish: Int
)