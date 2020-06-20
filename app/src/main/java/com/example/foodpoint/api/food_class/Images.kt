package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("front")
    val front: Front,
    @SerializedName("front_en")
    val frontEn: FrontEn,
    @SerializedName("ingredients")
    val ingredients: Ingredients,
    @SerializedName("ingredients_en")
    val ingredientsEn: IngredientsEn,
    @SerializedName("nutrition")
    val nutrition: Nutrition,
    @SerializedName("nutrition_en")
    val nutritionEn: NutritionEn,
    @SerializedName("1")
    val x1: X1,
    @SerializedName("2")
    val x2: X2,
    @SerializedName("3")
    val x3: X3,
    @SerializedName("4")
    val x4: X4,
    @SerializedName("5")
    val x5: X5
)