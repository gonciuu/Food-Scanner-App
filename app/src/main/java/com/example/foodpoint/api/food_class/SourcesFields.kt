package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class SourcesFields(
    @SerializedName("org-database-usda")
    val orgDatabaseUsda: OrgDatabaseUsda
)