package com.example.foodpoint.screens

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
import com.example.foodpoint.screens.view_models.FoodInfoViewModel
import kotlinx.android.synthetic.main.fragment_food_details.*


class FoodDetailsFragment : Fragment() {


    private lateinit var foodInfoViewModel: FoodInfoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_food_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        foodInfoViewModel = ViewModelProvider(requireActivity()).get(FoodInfoViewModel::class.java)
        foodInfoViewModel.getFood().observe(viewLifecycleOwner, Observer {
            t->
            Log.d("TAG",t.name.toString())
            Log.d("TAG",t.calories.toString())
            Log.d("TAG",t.carbohydrates.toString())
            Log.d("TAG",t.allergens.toString())
            Log.d("TAG",t.categories.toString())
            Log.d("TAG",t.fats.toString())
            Log.d("TAG",t.ingredients.toString())
        })
        setupNavigation()
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