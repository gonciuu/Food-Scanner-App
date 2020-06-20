package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class X3(
    @SerializedName("sizes")
    val sizes: SizesXXXXXXX,
    @SerializedName("uploaded_t")
    val uploadedT: Int,
    @SerializedName("uploader")
    val uploader: String
)