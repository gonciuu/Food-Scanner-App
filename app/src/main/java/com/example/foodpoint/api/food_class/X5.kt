package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class X5(
    @SerializedName("sizes")
    val sizes: SizesXXXXXXXXXX,
    @SerializedName("uploaded_t")
    val uploadedT: Int,
    @SerializedName("uploader")
    val uploader: String
)