package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class NutritionEn(
    @SerializedName("geometry")
    val geometry: String,
    @SerializedName("imgid")
    val imgid: String,
    @SerializedName("normalize")
    val normalize: String,
    @SerializedName("rev")
    val rev: String,
    @SerializedName("sizes")
    val sizes: SizesXXXXX,
    @SerializedName("white_magic")
    val whiteMagic: Any
)