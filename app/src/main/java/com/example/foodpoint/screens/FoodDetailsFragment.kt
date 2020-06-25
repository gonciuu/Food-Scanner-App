package com.example.foodpoint.screens

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Matrix
import android.os.Bundle
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
import com.example.foodpoint.screens.view_models.ScanViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_food_details.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random


class FoodDetailsFragment : Fragment() {


    private lateinit var foodInfoViewModel: FoodInfoViewModel
    private lateinit var food:SimplyfiFood
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_food_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val scanViewModel = ViewModelProvider(requireActivity()).get(ScanViewModel::class.java)
        scanViewModel.setBarcodeNumber(null)
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
        foodName.text = food.name
        setFoodCategories()
        setVeganAndVegetarianState()
        setImage()
        setAllergens()
    }
    private fun setVeganAndVegetarianState(){
        var superfoodCharset = "${food.name} is for vegan and for vegetarian"

        for (ingredient in food.ingredients) {
            if(ingredient.vegan != "yes"){
                superfoodCharset.replace("for vegan","not for vegan")
                break
            }
        }

        for (ingredient in food.ingredients) {
            if(ingredient.vegetarian != "yes"){
                superfoodCharset.replace("for vegetarian","not for vegetarian")
                break
            }
        }

        when(Random.nextInt(0,2)){
            0-> superfoodCharset += if(food.fats * (food.quantity/100) > 30) ". Has a lot of fats too!"
            else ". Has no many fats too!"

            1-> superfoodCharset += if(food.carbohydrates * (food.quantity/100) > 100) ". Has a lot of carbohydrates too!"
            else ". Has no many carbohydrates too!"

            2-> superfoodCharset += if(food.proteins * (food.quantity/100) > 30) ". Has a lot of proteins too!"
            else ". Has no many proteins too!"
        }


        vaganAndVegetarianState.text = superfoodCharset
    }


    @SuppressLint("SetTextI18n")
    private fun setAllergens(){
        if(food.allergens.isNotEmpty()){
            foodAllergensNutrinions.text = ""
            foodNotAllergensNutrinions.text = ""

            //---------ALLERGENS-------------
            food.allergens.forEach {
                foodAllergensNutrinions.text = foodAllergensNutrinions.text.toString() + it.removeRange(0,it.indexOf(":")+1) +", "
            }
            //-------------------------------
            //--------NOT ALLERGENS----------

            for (ingredient in food.ingredients) {
                for(i in food.allergens){
                    if(i != ingredient.text){
                        foodNotAllergensNutrinions.text = foodNotAllergensNutrinions.text.toString() + ingredient.text.removeRange(0,ingredient.text.indexOf(":")+1).replace("_","") +", "
                        break
                    }
                }
            }

        }
    }




    @SuppressLint("SetTextI18n")
    private fun setFoodCategories() {
        food.categories.forEach {
            foodCategories.text  = foodCategories.text.toString() + it.removeRange(0,it.indexOf(":")+1) + ", "
        }
    }


    private fun setImage(){
        CoroutineScope(Dispatchers.IO).launch{
            var image = Picasso.get().load(food.imageUrl).get()
            if(image.width > image.height){
                val matrix : Matrix? = Matrix()
                matrix?.postRotate(90f)
                image = Bitmap.createBitmap(image,0,0,image.width,image.height,matrix,true)
            }
            requireActivity().runOnUiThread {
                foodImage.setImageBitmap(image)
            }
        }

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