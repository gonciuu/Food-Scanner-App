package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class Nutriments(
    @SerializedName("calcium")
    val calcium: Double,
    @SerializedName("calcium_100g")
    val calcium100g: Double,
    @SerializedName("calcium_serving")
    val calciumServing: Double,
    @SerializedName("calcium_unit")
    val calciumUnit: String,
    @SerializedName("calcium_value")
    val calciumValue: Int,
    @SerializedName("carbohydrates")
    val carbohydrates: Double,
    @SerializedName("carbohydrates_100g")
    val carbohydrates100g: Double,
    @SerializedName("carbohydrates_serving")
    val carbohydratesServing: Double,
    @SerializedName("carbohydrates_unit")
    val carbohydratesUnit: String,
    @SerializedName("carbohydrates_value")
    val carbohydratesValue: Double,
    @SerializedName("cholesterol")
    val cholesterol: Int,
    @SerializedName("cholesterol_100g")
    val cholesterol100g: Int,
    @SerializedName("cholesterol_serving")
    val cholesterolServing: Int,
    @SerializedName("cholesterol_unit")
    val cholesterolUnit: String,
    @SerializedName("cholesterol_value")
    val cholesterolValue: Int,
    @SerializedName("energy")
    val energy: Int,
    @SerializedName("energy_100g")
    val energy100g: Int,
    @SerializedName("energy-kcal")
    val energyKcal: Int,
    @SerializedName("energy-kcal_100g")
    val energyKcal100g: Int,
    @SerializedName("energy-kcal_serving")
    val energyKcalServing: Int,
    @SerializedName("energy-kcal_unit")
    val energyKcalUnit: String,
    @SerializedName("energy-kcal_value")
    val energyKcalValue: Int,
    @SerializedName("energy_serving")
    val energyServing: Int,
    @SerializedName("energy_unit")
    val energyUnit: String,
    @SerializedName("energy_value")
    val energyValue: Int,
    @SerializedName("fat")
    val fat: Double,
    @SerializedName("fat_100g")
    val fat100g: Double,
    @SerializedName("fat_serving")
    val fatServing: Double,
    @SerializedName("fat_unit")
    val fatUnit: String,
    @SerializedName("fat_value")
    val fatValue: Double,
    @SerializedName("fiber")
    val fiber: Double,
    @SerializedName("fiber_100g")
    val fiber100g: Double,
    @SerializedName("fiber_serving")
    val fiberServing: Double,
    @SerializedName("fiber_unit")
    val fiberUnit: String,
    @SerializedName("fiber_value")
    val fiberValue: Double,
    @SerializedName("fruits-vegetables-nuts-estimate-from-ingredients_100g")
    val fruitsVegetablesNutsEstimateFromIngredients100g: Int,
    @SerializedName("iron")
    val iron: Double,
    @SerializedName("iron_100g")
    val iron100g: Double,
    @SerializedName("iron_serving")
    val ironServing: Double,
    @SerializedName("iron_unit")
    val ironUnit: String,
    @SerializedName("iron_value")
    val ironValue: Double,
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
    @SerializedName("proteins_serving")
    val proteinsServing: Double,
    @SerializedName("proteins_unit")
    val proteinsUnit: String,
    @SerializedName("proteins_value")
    val proteinsValue: Double,
    @SerializedName("salt")
    val salt: Double,
    @SerializedName("salt_100g")
    val salt100g: Double,
    @SerializedName("salt_serving")
    val saltServing: Double,
    @SerializedName("salt_unit")
    val saltUnit: String,
    @SerializedName("salt_value")
    val saltValue: Double,
    @SerializedName("saturated-fat")
    val saturatedFat: Double,
    @SerializedName("saturated-fat_100g")
    val saturatedFat100g: Double,
    @SerializedName("saturated-fat_serving")
    val saturatedFatServing: Double,
    @SerializedName("saturated-fat_unit")
    val saturatedFatUnit: String,
    @SerializedName("saturated-fat_value")
    val saturatedFatValue: Double,
    @SerializedName("sodium")
    val sodium: Double,
    @SerializedName("sodium_100g")
    val sodium100g: Double,
    @SerializedName("sodium_serving")
    val sodiumServing: Double,
    @SerializedName("sodium_unit")
    val sodiumUnit: String,
    @SerializedName("sodium_value")
    val sodiumValue: Double,
    @SerializedName("sugars")
    val sugars: Double,
    @SerializedName("sugars_100g")
    val sugars100g: Double,
    @SerializedName("sugars_serving")
    val sugarsServing: Double,
    @SerializedName("sugars_unit")
    val sugarsUnit: String,
    @SerializedName("sugars_value")
    val sugarsValue: Double,
    @SerializedName("trans-fat")
    val transFat: Int,
    @SerializedName("trans-fat_100g")
    val transFat100g: Int,
    @SerializedName("trans-fat_serving")
    val transFatServing: Int,
    @SerializedName("trans-fat_unit")
    val transFatUnit: String,
    @SerializedName("trans-fat_value")
    val transFatValue: Int,
    @SerializedName("vitamin-a")
    val vitaminA: Double,
    @SerializedName("vitamin-a_100g")
    val vitaminA100g: Double,
    @SerializedName("vitamin-a_serving")
    val vitaminAServing: Double,
    @SerializedName("vitamin-a_unit")
    val vitaminAUnit: String,
    @SerializedName("vitamin-a_value")
    val vitaminAValue: Int,
    @SerializedName("vitamin-c")
    val vitaminC: Int,
    @SerializedName("vitamin-c_100g")
    val vitaminC100g: Int,
    @SerializedName("vitamin-c_serving")
    val vitaminCServing: Int,
    @SerializedName("vitamin-c_unit")
    val vitaminCUnit: String,
    @SerializedName("vitamin-c_value")
    val vitaminCValue: Int
)