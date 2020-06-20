package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class FrontEn(
    @SerializedName("geometry")
    val geometry: String,
    @SerializedName("imgid")
    val imgid: String,
    @SerializedName("normalize")
    val normalize: Any,
    @SerializedName("rev")
    val rev: String,
    @SerializedName("sizes")
    val sizes: SizesX,
    @SerializedName("white_magic")
    val whiteMagic: Any
)