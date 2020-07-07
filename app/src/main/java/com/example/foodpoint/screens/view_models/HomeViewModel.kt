package com.example.foodpoint.screens.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodpoint.api.food_class.food_class_to_communicate_wwith_others.SimplyfiFood

class HomeViewModel : ViewModel() {

    val foods = MutableLiveData<ArrayList<SimplyfiFood>>()

    fun setFood(foodList:ArrayList<SimplyfiFood>?){
        foods.value = foodList
    }

    fun getFood():LiveData<ArrayList<SimplyfiFood>> {
        return foods
    }

}