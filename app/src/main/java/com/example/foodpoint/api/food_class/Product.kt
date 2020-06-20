package com.example.foodpoint.api.food_class


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("additives_debug_tags")
    val additivesDebugTags: List<Any>,
    @SerializedName("additives_n")
    val additivesN: Int,
    @SerializedName("additives_old_n")
    val additivesOldN: Int,
    @SerializedName("additives_old_tags")
    val additivesOldTags: List<String>,
    @SerializedName("additives_original_tags")
    val additivesOriginalTags: List<String>,
    @SerializedName("additives_prev_original_tags")
    val additivesPrevOriginalTags: List<String>,
    @SerializedName("additives_tags")
    val additivesTags: List<String>,
    @SerializedName("additives_tags_n")
    val additivesTagsN: Any,
    @SerializedName("allergens")
    val allergens: String,
    @SerializedName("allergens_from_ingredients")
    val allergensFromIngredients: String,
    @SerializedName("allergens_from_user")
    val allergensFromUser: String,
    @SerializedName("allergens_hierarchy")
    val allergensHierarchy: List<Any>,
    @SerializedName("allergens_tags")
    val allergensTags: List<Any>,
    @SerializedName("amino_acids_prev_tags")
    val aminoAcidsPrevTags: List<Any>,
    @SerializedName("amino_acids_tags")
    val aminoAcidsTags: List<Any>,
    @SerializedName("brand_owner")
    val brandOwner: String,
    @SerializedName("brand_owner_imported")
    val brandOwnerImported: String,
    @SerializedName("brands")
    val brands: String,
    @SerializedName("brands_debug_tags")
    val brandsDebugTags: List<Any>,
    @SerializedName("brands_tags")
    val brandsTags: List<String>,
    @SerializedName("categories")
    val categories: String,
    @SerializedName("categories_hierarchy")
    val categoriesHierarchy: List<String>,
    @SerializedName("categories_imported")
    val categoriesImported: String,
    @SerializedName("categories_lc")
    val categoriesLc: String,
    @SerializedName("categories_tags")
    val categoriesTags: List<String>,
    @SerializedName("category_properties")
    val categoryProperties: CategoryProperties,
    @SerializedName("checkers")
    val checkers: List<Any>,
    @SerializedName("checkers_tags")
    val checkersTags: List<Any>,
    @SerializedName("ciqual_food_name_tags")
    val ciqualFoodNameTags: List<String>,
    @SerializedName("cities_tags")
    val citiesTags: List<Any>,
    @SerializedName("code")
    val code: String,
    @SerializedName("codes_tags")
    val codesTags: List<String>,
    @SerializedName("compared_to_category")
    val comparedToCategory: String,
    @SerializedName("complete")
    val complete: Int,
    @SerializedName("completed_t")
    val completedT: Int,
    @SerializedName("completeness")
    val completeness: Double,
    @SerializedName("correctors")
    val correctors: List<String>,
    @SerializedName("correctors_tags")
    val correctorsTags: List<String>,
    @SerializedName("countries")
    val countries: String,
    @SerializedName("countries_debug_tags")
    val countriesDebugTags: List<Any>,
    @SerializedName("countries_hierarchy")
    val countriesHierarchy: List<String>,
    @SerializedName("countries_imported")
    val countriesImported: String,
    @SerializedName("countries_lc")
    val countriesLc: String,
    @SerializedName("countries_tags")
    val countriesTags: List<String>,
    @SerializedName("created_t")
    val createdT: Int,
    @SerializedName("creator")
    val creator: String,
    @SerializedName("data_quality_bugs_tags")
    val dataQualityBugsTags: List<Any>,
    @SerializedName("data_quality_errors_tags")
    val dataQualityErrorsTags: List<Any>,
    @SerializedName("data_quality_info_tags")
    val dataQualityInfoTags: List<String>,
    @SerializedName("data_quality_tags")
    val dataQualityTags: List<String>,
    @SerializedName("data_quality_warnings_tags")
    val dataQualityWarningsTags: List<String>,
    @SerializedName("data_sources")
    val dataSources: String,
    @SerializedName("data_sources_imported")
    val dataSourcesImported: String,
    @SerializedName("data_sources_tags")
    val dataSourcesTags: List<String>,
    @SerializedName("debug_param_sorted_langs")
    val debugParamSortedLangs: List<String>,
    @SerializedName("editors")
    val editors: List<String>,
    @SerializedName("editors_tags")
    val editorsTags: List<String>,
    @SerializedName("emb_codes")
    val embCodes: String,
    @SerializedName("emb_codes_20141016")
    val embCodes20141016: String,
    @SerializedName("emb_codes_debug_tags")
    val embCodesDebugTags: List<Any>,
    @SerializedName("emb_codes_orig")
    val embCodesOrig: String,
    @SerializedName("emb_codes_tags")
    val embCodesTags: List<Any>,
    @SerializedName("entry_dates_tags")
    val entryDatesTags: List<String>,
    @SerializedName("expiration_date")
    val expirationDate: String,
    @SerializedName("expiration_date_debug_tags")
    val expirationDateDebugTags: List<Any>,
    @SerializedName("fruits-vegetables-nuts_100g_estimate")
    val fruitsVegetablesNuts100gEstimate: Int,
    @SerializedName("generic_name")
    val genericName: String,
    @SerializedName("generic_name_en")
    val genericNameEn: String,
    @SerializedName("generic_name_en_debug_tags")
    val genericNameEnDebugTags: List<Any>,
    @SerializedName("_id")
    val id: String,
    @SerializedName("image_front_small_url")
    val imageFrontSmallUrl: String,
    @SerializedName("image_front_thumb_url")
    val imageFrontThumbUrl: String,
    @SerializedName("image_front_url")
    val imageFrontUrl: String,
    @SerializedName("image_ingredients_small_url")
    val imageIngredientsSmallUrl: String,
    @SerializedName("image_ingredients_thumb_url")
    val imageIngredientsThumbUrl: String,
    @SerializedName("image_ingredients_url")
    val imageIngredientsUrl: String,
    @SerializedName("image_nutrition_small_url")
    val imageNutritionSmallUrl: String,
    @SerializedName("image_nutrition_thumb_url")
    val imageNutritionThumbUrl: String,
    @SerializedName("image_nutrition_url")
    val imageNutritionUrl: String,
    @SerializedName("image_small_url")
    val imageSmallUrl: String,
    @SerializedName("image_thumb_url")
    val imageThumbUrl: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("images")
    val images: Images,
    @SerializedName("informers")
    val informers: List<String>,
    @SerializedName("informers_tags")
    val informersTags: List<String>,
    @SerializedName("ingredients")
    val ingredients: List<Ingredient>,
    @SerializedName("ingredients_analysis_tags")
    val ingredientsAnalysisTags: List<String>,
    @SerializedName("ingredients_debug")
    val ingredientsDebug: List<Any>,
    @SerializedName("ingredients_from_or_that_may_be_from_palm_oil_n")
    val ingredientsFromOrThatMayBeFromPalmOilN: Int,
    @SerializedName("ingredients_from_palm_oil_n")
    val ingredientsFromPalmOilN: Int,
    @SerializedName("ingredients_from_palm_oil_tags")
    val ingredientsFromPalmOilTags: List<Any>,
    @SerializedName("ingredients_hierarchy")
    val ingredientsHierarchy: List<String>,
    @SerializedName("ingredients_ids_debug")
    val ingredientsIdsDebug: List<String>,
    @SerializedName("ingredients_n")
    val ingredientsN: Int,
    @SerializedName("ingredients_n_tags")
    val ingredientsNTags: List<String>,
    @SerializedName("ingredients_original_tags")
    val ingredientsOriginalTags: List<String>,
    @SerializedName("ingredients_percent_analysis")
    val ingredientsPercentAnalysis: Int,
    @SerializedName("ingredients_tags")
    val ingredientsTags: List<String>,
    @SerializedName("ingredients_text")
    val ingredientsText: String,
    @SerializedName("ingredients_text_debug")
    val ingredientsTextDebug: String,
    @SerializedName("ingredients_text_en")
    val ingredientsTextEn: String,
    @SerializedName("ingredients_text_en_debug_tags")
    val ingredientsTextEnDebugTags: List<Any>,
    @SerializedName("ingredients_text_en_imported")
    val ingredientsTextEnImported: String,
    @SerializedName("ingredients_text_with_allergens")
    val ingredientsTextWithAllergens: String,
    @SerializedName("ingredients_text_with_allergens_en")
    val ingredientsTextWithAllergensEn: String,
    @SerializedName("ingredients_that_may_be_from_palm_oil_n")
    val ingredientsThatMayBeFromPalmOilN: Int,
    @SerializedName("ingredients_that_may_be_from_palm_oil_tags")
    val ingredientsThatMayBeFromPalmOilTags: List<Any>,
    @SerializedName("interface_version_created")
    val interfaceVersionCreated: String,
    @SerializedName("interface_version_modified")
    val interfaceVersionModified: String,
    @SerializedName("_keywords")
    val keywords: List<String>,
    @SerializedName("known_ingredients_n")
    val knownIngredientsN: Int,
    @SerializedName("labels")
    val labels: String,
    @SerializedName("labels_hierarchy")
    val labelsHierarchy: List<String>,
    @SerializedName("labels_lc")
    val labelsLc: String,
    @SerializedName("labels_prev_hierarchy")
    val labelsPrevHierarchy: List<String>,
    @SerializedName("labels_prev_tags")
    val labelsPrevTags: List<String>,
    @SerializedName("labels_tags")
    val labelsTags: List<String>,
    @SerializedName("lang")
    val lang: String,
    @SerializedName("lang_debug_tags")
    val langDebugTags: List<Any>,
    @SerializedName("languages")
    val languages: Languages,
    @SerializedName("languages_codes")
    val languagesCodes: LanguagesCodes,
    @SerializedName("languages_hierarchy")
    val languagesHierarchy: List<String>,
    @SerializedName("languages_tags")
    val languagesTags: List<String>,
    @SerializedName("last_edit_dates_tags")
    val lastEditDatesTags: List<String>,
    @SerializedName("last_editor")
    val lastEditor: String,
    @SerializedName("last_image_dates_tags")
    val lastImageDatesTags: List<String>,
    @SerializedName("last_image_t")
    val lastImageT: Int,
    @SerializedName("last_modified_by")
    val lastModifiedBy: String,
    @SerializedName("last_modified_t")
    val lastModifiedT: Int,
    @SerializedName("lc")
    val lc: String,
    @SerializedName("lc_imported")
    val lcImported: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("link_debug_tags")
    val linkDebugTags: List<Any>,
    @SerializedName("manufacturing_places")
    val manufacturingPlaces: String,
    @SerializedName("manufacturing_places_debug_tags")
    val manufacturingPlacesDebugTags: List<Any>,
    @SerializedName("manufacturing_places_tags")
    val manufacturingPlacesTags: List<Any>,
    @SerializedName("max_imgid")
    val maxImgid: String,
    @SerializedName("minerals_prev_tags")
    val mineralsPrevTags: List<Any>,
    @SerializedName("minerals_tags")
    val mineralsTags: List<Any>,
    @SerializedName("misc_tags")
    val miscTags: List<String>,
    @SerializedName("new_additives_n")
    val newAdditivesN: Int,
    @SerializedName("no_nutrition_data")
    val noNutritionData: String,
    @SerializedName("nova_group")
    val novaGroup: Int,
    @SerializedName("nova_group_debug")
    val novaGroupDebug: String,
    @SerializedName("nova_groups")
    val novaGroups: String,
    @SerializedName("nova_groups_tags")
    val novaGroupsTags: List<String>,
    @SerializedName("nucleotides_prev_tags")
    val nucleotidesPrevTags: List<Any>,
    @SerializedName("nucleotides_tags")
    val nucleotidesTags: List<Any>,
    @SerializedName("nutrient_levels")
    val nutrientLevels: NutrientLevels,
    @SerializedName("nutrient_levels_tags")
    val nutrientLevelsTags: List<String>,
    @SerializedName("nutriments")
    val nutriments: Nutriments,
    @SerializedName("nutriscore_data")
    val nutriscoreData: NutriscoreData,
    @SerializedName("nutriscore_grade")
    val nutriscoreGrade: String,
    @SerializedName("nutriscore_score")
    val nutriscoreScore: Int,
    @SerializedName("nutrition_data")
    val nutritionData: String,
    @SerializedName("nutrition_data_per")
    val nutritionDataPer: String,
    @SerializedName("nutrition_data_per_debug_tags")
    val nutritionDataPerDebugTags: List<Any>,
    @SerializedName("nutrition_data_per_imported")
    val nutritionDataPerImported: String,
    @SerializedName("nutrition_data_prepared")
    val nutritionDataPrepared: String,
    @SerializedName("nutrition_data_prepared_per")
    val nutritionDataPreparedPer: String,
    @SerializedName("nutrition_data_prepared_per_debug_tags")
    val nutritionDataPreparedPerDebugTags: List<Any>,
    @SerializedName("nutrition_data_prepared_per_imported")
    val nutritionDataPreparedPerImported: String,
    @SerializedName("nutrition_grade_fr")
    val nutritionGradeFr: String,
    @SerializedName("nutrition_grades")
    val nutritionGrades: String,
    @SerializedName("nutrition_grades_tags")
    val nutritionGradesTags: List<String>,
    @SerializedName("nutrition_score_beverage")
    val nutritionScoreBeverage: Int,
    @SerializedName("nutrition_score_warning_fruits_vegetables_nuts_estimate_from_ingredients")
    val nutritionScoreWarningFruitsVegetablesNutsEstimateFromIngredients: Int,
    @SerializedName("nutrition_score_warning_fruits_vegetables_nuts_estimate_from_ingredients_value")
    val nutritionScoreWarningFruitsVegetablesNutsEstimateFromIngredientsValue: Int,
    @SerializedName("origins")
    val origins: String,
    @SerializedName("origins_debug_tags")
    val originsDebugTags: List<Any>,
    @SerializedName("origins_tags")
    val originsTags: List<String>,
    @SerializedName("other_nutritional_substances_tags")
    val otherNutritionalSubstancesTags: List<Any>,
    @SerializedName("packaging")
    val packaging: String,
    @SerializedName("packaging_debug_tags")
    val packagingDebugTags: List<Any>,
    @SerializedName("packaging_tags")
    val packagingTags: List<String>,
    @SerializedName("photographers")
    val photographers: List<String>,
    @SerializedName("photographers_tags")
    val photographersTags: List<String>,
    @SerializedName("pnns_groups_1")
    val pnnsGroups1: String,
    @SerializedName("pnns_groups_1_tags")
    val pnnsGroups1Tags: List<String>,
    @SerializedName("pnns_groups_2")
    val pnnsGroups2: String,
    @SerializedName("pnns_groups_2_tags")
    val pnnsGroups2Tags: List<String>,
    @SerializedName("popularity_tags")
    val popularityTags: List<String>,
    @SerializedName("product_name")
    val productName: String,
    @SerializedName("product_name_en")
    val productNameEn: String,
    @SerializedName("product_name_en_debug_tags")
    val productNameEnDebugTags: List<Any>,
    @SerializedName("product_name_en_imported")
    val productNameEnImported: String,
    @SerializedName("product_quantity")
    val productQuantity: Int,
    @SerializedName("purchase_places")
    val purchasePlaces: String,
    @SerializedName("purchase_places_debug_tags")
    val purchasePlacesDebugTags: List<Any>,
    @SerializedName("purchase_places_tags")
    val purchasePlacesTags: List<Any>,
    @SerializedName("quantity")
    val quantity: String,
    @SerializedName("quantity_debug_tags")
    val quantityDebugTags: List<Any>,
    @SerializedName("rev")
    val rev: Int,
    @SerializedName("scans_n")
    val scansN: Int,
    @SerializedName("selected_images")
    val selectedImages: SelectedImages,
    @SerializedName("serving_quantity")
    val servingQuantity: Int,
    @SerializedName("serving_size")
    val servingSize: String,
    @SerializedName("serving_size_debug_tags")
    val servingSizeDebugTags: List<Any>,
    @SerializedName("serving_size_imported")
    val servingSizeImported: String,
    @SerializedName("sortkey")
    val sortkey: Long,
    @SerializedName("sources")
    val sources: List<Source>,
    @SerializedName("sources_fields")
    val sourcesFields: SourcesFields,
    @SerializedName("states")
    val states: String,
    @SerializedName("states_hierarchy")
    val statesHierarchy: List<String>,
    @SerializedName("states_tags")
    val statesTags: List<String>,
    @SerializedName("stores")
    val stores: String,
    @SerializedName("stores_debug_tags")
    val storesDebugTags: List<Any>,
    @SerializedName("stores_tags")
    val storesTags: List<Any>,
    @SerializedName("traces")
    val traces: String,
    @SerializedName("traces_debug_tags")
    val tracesDebugTags: List<Any>,
    @SerializedName("traces_from_ingredients")
    val tracesFromIngredients: String,
    @SerializedName("traces_from_user")
    val tracesFromUser: String,
    @SerializedName("traces_hierarchy")
    val tracesHierarchy: List<String>,
    @SerializedName("traces_tags")
    val tracesTags: List<String>,
    @SerializedName("unique_scans_n")
    val uniqueScansN: Int,
    @SerializedName("unknown_ingredients_n")
    val unknownIngredientsN: Int,
    @SerializedName("unknown_nutrients_tags")
    val unknownNutrientsTags: List<Any>,
    @SerializedName("update_key")
    val updateKey: String,
    @SerializedName("vitamins_prev_tags")
    val vitaminsPrevTags: List<Any>,
    @SerializedName("vitamins_tags")
    val vitaminsTags: List<Any>
)