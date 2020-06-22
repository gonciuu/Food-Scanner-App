package com.example.foodpoint.api.service

import com.example.foodpoint.api.food_class.Food
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FoodService {

    @GET("{number}.json")
    fun getFoodAsync(@Path("number") number:String) :Deferred<Response<Food>>

}