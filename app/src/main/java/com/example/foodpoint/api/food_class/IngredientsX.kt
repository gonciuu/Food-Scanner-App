package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class IngredientsX(
    @SerializedName("display")
    val display: DisplayX,
    @SerializedName("small")
    val small: SmallX,
    @SerializedName("thumb")
    val thumb: ThumbX
)