package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class Nutriments(
    @SerializedName("carbohydrates")
    val carbohydrates: Int,
    @SerializedName("carbohydrates_100g")
    val carbohydrates100g: Int,
    @SerializedName("carbohydrates_unit")
    val carbohydratesUnit: String,
    @SerializedName("carbohydrates_value")
    val carbohydratesValue: Int,
    @SerializedName("carbon-footprint-from-known-ingredients_100g")
    val carbonFootprintFromKnownIngredients100g: Int,
    @SerializedName("carbon-footprint-from-known-ingredients_product")
    val carbonFootprintFromKnownIngredientsProduct: Int,
    @SerializedName("energy")
    val energy: Int,
    @SerializedName("energy_100g")
    val energy100g: Int,
    @SerializedName("energy-kcal")
    val energyKcal: Int,
    @SerializedName("energy-kcal_100g")
    val energyKcal100g: Int,
    @SerializedName("energy-kcal_unit")
    val energyKcalUnit: String,
    @SerializedName("energy-kcal_value")
    val energyKcalValue: Int,
    @SerializedName("energy-kj")
    val energyKj: Int,
    @SerializedName("energy-kj_100g")
    val energyKj100g: Int,
    @SerializedName("energy-kj_unit")
    val energyKjUnit: String,
    @SerializedName("energy-kj_value")
    val energyKjValue: Int,
    @SerializedName("energy_unit")
    val energyUnit: String,
    @SerializedName("energy_value")
    val energyValue: Int,
    @SerializedName("fat")
    val fat: Double,
    @SerializedName("fat_100g")
    val fat100g: Double,
    @SerializedName("fat_unit")
    val fatUnit: String,
    @SerializedName("fat_value")
    val fatValue: Double,
    @SerializedName("fiber")
    val fiber: Double,
    @SerializedName("fiber_100g")
    val fiber100g: Double,
    @SerializedName("fiber_unit")
    val fiberUnit: String,
    @SerializedName("fiber_value")
    val fiberValue: Double,
    @SerializedName("fruits-vegetables-nuts-estimate-from-ingredients_100g")
    val fruitsVegetablesNutsEstimateFromIngredients100g: Int,
    @SerializedName("nova-group")
    val novaGroup: Int,
    @SerializedName("nova-group_100g")
    val novaGroup100g: Int,
    @SerializedName("nova-group_serving")
    val novaGroupServing: Int,
    @SerializedName("nutrition-score-fr")
    val nutritionScoreFr: Int,
    @SerializedName("nutrition-score-fr_100g")
    val nutritionScoreFr100g: Int,
    @SerializedName("nutrition-score-fr_serving")
    val nutritionScoreFrServing: Int,
    @SerializedName("proteins")
    val proteins: Double,
    @SerializedName("proteins_100g")
    val proteins100g: Double,
    @SerializedName("proteins_unit")
    val proteinsUnit: String,
    @SerializedName("proteins_value")
    val proteinsValue: Double,
    @SerializedName("salt")
    val salt: Double,
    @SerializedName("salt_100g")
    val salt100g: Double,
    @SerializedName("salt_unit")
    val saltUnit: String,
    @SerializedName("salt_value")
    val saltValue: Double,
    @SerializedName("saturated-fat")
    val saturatedFat: Double,
    @SerializedName("saturated-fat_100g")
    val saturatedFat100g: Double,
    @SerializedName("saturated-fat_unit")
    val saturatedFatUnit: String,
    @SerializedName("saturated-fat_value")
    val saturatedFatValue: Double,
    @SerializedName("sodium")
    val sodium: Double,
    @SerializedName("sodium_100g")
    val sodium100g: Double,
    @SerializedName("sodium_unit")
    val sodiumUnit: String,
    @SerializedName("sodium_value")
    val sodiumValue: Double,
    @SerializedName("sugars")
    val sugars: Int,
    @SerializedName("sugars_100g")
    val sugars100g: Int,
    @SerializedName("sugars_unit")
    val sugarsUnit: String,
    @SerializedName("sugars_value")
    val sugarsValue: Int
)