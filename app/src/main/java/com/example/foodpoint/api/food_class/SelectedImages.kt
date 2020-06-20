package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class SelectedImages(
    @SerializedName("front")
    val front: FrontX,
    @SerializedName("ingredients")
    val ingredients: IngredientsX,
    @SerializedName("nutrition")
    val nutrition: NutritionX
)