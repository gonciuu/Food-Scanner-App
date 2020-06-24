package com.example.foodpoint.screens.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodpoint.api.food_class.food_class_to_communicate_wwith_others.SimplyfiFood

class FoodInfoViewModel : ViewModel() {

    val simplyfiFood = MutableLiveData<SimplyfiFood>()

    fun setFood(food:SimplyfiFood){
        this.simplyfiFood.value = food
    }

    fun getFood():LiveData<SimplyfiFood> = this.simplyfiFood
}