package com.example.foodpoint.api.service

import com.example.foodpoint.api.food_class.Food
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val instance : FoodService by lazy {

        val retrofit = Retrofit.Builder().baseUrl("https://world.openfoodfacts.org/api/v0/product")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(OkHttpClient.Builder().build())
            .build()

        retrofit.create(FoodService::class.java)
    }
}