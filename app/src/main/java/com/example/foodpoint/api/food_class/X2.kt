package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class X2(
    @SerializedName("sizes")
    val sizes: SizesXXXXXX,
    @SerializedName("uploaded_t")
    val uploadedT: String,
    @SerializedName("uploader")
    val uploader: String
)