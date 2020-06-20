package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class NutriscoreData(
    @SerializedName("energy")
    val energy: Int,
    @SerializedName("energy_points")
    val energyPoints: Int,
    @SerializedName("energy_value")
    val energyValue: Int,
    @SerializedName("fiber")
    val fiber: Double,
    @SerializedName("fiber_points")
    val fiberPoints: Int,
    @SerializedName("fiber_value")
    val fiberValue: Double,
    @SerializedName("fruits_vegetables_nuts_colza_walnut_olive_oils")
    val fruitsVegetablesNutsColzaWalnutOliveOils: Int,
    @SerializedName("fruits_vegetables_nuts_colza_walnut_olive_oils_points")
    val fruitsVegetablesNutsColzaWalnutOliveOilsPoints: Int,
    @SerializedName("fruits_vegetables_nuts_colza_walnut_olive_oils_value")
    val fruitsVegetablesNutsColzaWalnutOliveOilsValue: Int,
    @SerializedName("grade")
    val grade: String,
    @SerializedName("is_beverage")
    val isBeverage: Int,
    @SerializedName("is_cheese")
    val isCheese: Int,
    @SerializedName("is_fat")
    val isFat: Int,
    @SerializedName("is_water")
    val isWater: Int,
    @SerializedName("negative_points")
    val negativePoints: Int,
    @SerializedName("positive_points")
    val positivePoints: Int,
    @SerializedName("proteins")
    val proteins: Double,
    @SerializedName("proteins_points")
    val proteinsPoints: Int,
    @SerializedName("proteins_value")
    val proteinsValue: Double,
    @SerializedName("saturated_fat")
    val saturatedFat: Double,
    @SerializedName("saturated_fat_points")
    val saturatedFatPoints: Int,
    @SerializedName("saturated_fat_ratio")
    val saturatedFatRatio: Double,
    @SerializedName("saturated_fat_ratio_points")
    val saturatedFatRatioPoints: Int,
    @SerializedName("saturated_fat_ratio_value")
    val saturatedFatRatioValue: Int,
    @SerializedName("saturated_fat_value")
    val saturatedFatValue: Double,
    @SerializedName("score")
    val score: Int,
    @SerializedName("sodium")
    val sodium: Int,
    @SerializedName("sodium_points")
    val sodiumPoints: Int,
    @SerializedName("sodium_value")
    val sodiumValue: Int,
    @SerializedName("sugars")
    val sugars: Double,
    @SerializedName("sugars_points")
    val sugarsPoints: Int,
    @SerializedName("sugars_value")
    val sugarsValue: Double
)