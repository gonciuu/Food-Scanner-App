package com.example.foodpoint.screens

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.foodpoint.R
import com.example.foodpoint.api.food_class.food_class_to_communicate_wwith_others.SimplyfiFood
import com.example.foodpoint.screens.view_models.FoodInfoViewModel
import kotlinx.android.synthetic.main.fragment_food_details.*


class FoodDetailsFragment : Fragment() {


    private lateinit var foodInfoViewModel: FoodInfoViewModel
    private lateinit var food:SimplyfiFood
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_food_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        foodInfoViewModel = ViewModelProvider(requireActivity()).get(FoodInfoViewModel::class.java)
        foodInfoViewModel.getFood().observe(viewLifecycleOwner, Observer {
            t->
            food = t
            setFoodInfo()
        })

        setupNavigation()
    }

    @SuppressLint("SetTextI18n")
    private fun setFoodInfo(){
        caloriesCount.text = (food.calories * (food.quantity/100)).toString()
        carbohydratesCount.text = (food.carbohydrates * (food.quantity/100)).toString() + " g"
        proteinsCount.text = (food.proteins * (food.quantity/100)).toString()+ " g"
        fatCount.text = (food.fats * (food.quantity/100)).toString()+ " g"
    }

    private fun setupNavigation(){
        backToHomeButton.setOnClickListener {
            findNavController().navigate(R.id.action_foodDetailsFragment_to_homeFragment)
        }
        scanAgainButton.setOnClickListener {
            findNavController().navigate(R.id.action_foodDetailsFragment_to_scanFragment)
        }
    }
}