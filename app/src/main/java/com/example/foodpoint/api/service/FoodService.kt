package com.example.foodpoint.api.service

import com.example.foodpoint.api.food_class.Food
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface FoodService {

    @GET("/5900397017412.json")
    fun getFoodAsync() :Deferred<Response<Food>>

}