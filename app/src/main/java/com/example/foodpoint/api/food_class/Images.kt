package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("front_pl")
    val frontPl: FrontPl,
    @SerializedName("ingredients_fr")
    val ingredientsFr: IngredientsFr,
    @SerializedName("ingredients_pl")
    val ingredientsPl: IngredientsPl,
    @SerializedName("nutrition_fr")
    val nutritionFr: NutritionFr,
    @SerializedName("nutrition_pl")
    val nutritionPl: NutritionPl,
    @SerializedName("1")
    val x1: X1,
    @SerializedName("2")
    val x2: X2,
    @SerializedName("3")
    val x3: X3
)