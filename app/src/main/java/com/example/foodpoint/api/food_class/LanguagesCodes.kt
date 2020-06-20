package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class LanguagesCodes(
    @SerializedName("de")
    val de: Int,
    @SerializedName("fr")
    val fr: Int,
    @SerializedName("pl")
    val pl: Int
)