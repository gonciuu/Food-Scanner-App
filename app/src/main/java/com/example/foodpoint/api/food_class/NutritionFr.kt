package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class NutritionFr(
    @SerializedName("angle")
    val angle: Any,
    @SerializedName("geometry")
    val geometry: String,
    @SerializedName("imgid")
    val imgid: String,
    @SerializedName("normalize")
    val normalize: String,
    @SerializedName("ocr")
    val ocr: Int,
    @SerializedName("orientation")
    val orientation: String,
    @SerializedName("rev")
    val rev: String,
    @SerializedName("sizes")
    val sizes: SizesXXX,
    @SerializedName("white_magic")
    val whiteMagic: String,
    @SerializedName("x1")
    val x1: Any,
    @SerializedName("x2")
    val x2: Any,
    @SerializedName("y1")
    val y1: Any,
    @SerializedName("y2")
    val y2: Any
)