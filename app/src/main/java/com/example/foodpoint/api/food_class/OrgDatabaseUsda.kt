package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class OrgDatabaseUsda(
    @SerializedName("available_date")
    val availableDate: String,
    @SerializedName("fdc_category")
    val fdcCategory: String,
    @SerializedName("fdc_data_source")
    val fdcDataSource: String,
    @SerializedName("fdc_id")
    val fdcId: String,
    @SerializedName("modified_date")
    val modifiedDate: String,
    @SerializedName("publication_date")
    val publicationDate: String
)