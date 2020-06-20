package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("fields")
    val fields: List<String>,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: List<Any>,
    @SerializedName("import_t")
    val importT: Int,
    @SerializedName("manufacturer")
    val manufacturer: Any,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)