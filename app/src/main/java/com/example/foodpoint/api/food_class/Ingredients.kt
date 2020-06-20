package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class Ingredients(
    @SerializedName("geometry")
    val geometry: String,
    @SerializedName("imgid")
    val imgid: String,
    @SerializedName("normalize")
    val normalize: String,
    @SerializedName("rev")
    val rev: String,
    @SerializedName("sizes")
    val sizes: SizesXX,
    @SerializedName("white_magic")
    val whiteMagic: Any
)