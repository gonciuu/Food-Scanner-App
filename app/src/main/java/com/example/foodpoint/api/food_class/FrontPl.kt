package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class FrontPl(
    @SerializedName("angle")
    val angle: Int,
    @SerializedName("geometry")
    val geometry: String,
    @SerializedName("imgid")
    val imgid: String,
    @SerializedName("normalize")
    val normalize: Any,
    @SerializedName("rev")
    val rev: String,
    @SerializedName("sizes")
    val sizes: Sizes,
    @SerializedName("white_magic")
    val whiteMagic: Any,
    @SerializedName("x1")
    val x1: String,
    @SerializedName("x2")
    val x2: String,
    @SerializedName("y1")
    val y1: String,
    @SerializedName("y2")
    val y2: String
)