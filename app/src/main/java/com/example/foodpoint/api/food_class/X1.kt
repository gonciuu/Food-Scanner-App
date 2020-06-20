package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class X1(
    @SerializedName("sizes")
    val sizes: SizesXXXXX,
    @SerializedName("uploaded_t")
    val uploadedT: String,
    @SerializedName("uploader")
    val uploader: String
)