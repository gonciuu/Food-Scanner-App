package com.example.foodpoint.screens

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.foodpoint.R
import com.example.foodpoint.api.food_class.Food
import com.example.foodpoint.api.food_class.Ingredient
import com.example.foodpoint.api.food_class.food_class_to_communicate_wwith_others.SimplyfiFood
import com.example.foodpoint.api.service.FoodService
import com.example.foodpoint.api.service.RetrofitClient
import com.example.foodpoint.screens.view_models.FoodInfoViewModel
import com.example.foodpoint.screens.view_models.ScanViewModel
import kotlinx.android.synthetic.main.fragment_scan.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class ScanFragment : Fragment() {

    private lateinit var scanViewModel: ScanViewModel
    private lateinit var foodInfoViewModel: FoodInfoViewModel
    private lateinit var food: Food
    private var handler:Handler = Handler()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_scan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scanViewModel = ViewModelProvider(requireActivity()).get(ScanViewModel::class.java)
        foodInfoViewModel = ViewModelProvider(requireActivity()).get(FoodInfoViewModel::class.java)

        getBarCode()
        setupFragment()
    }


    //--------------------------------------ADD BUTTON CLICK TO SCAN BARCODES-----------------------------------------

    private fun setupFragment() {

        showFoodDetailsButton.setOnClickListener {
            showScanLabelAnimation()
            getFoodInfo(barcodeET.text.toString())
        }

        scanImage.setOnClickListener {
            findNavController().navigate(R.id.action_scanFragment_to_scanBarcodeCameraViewFragment)
        }
    }

    //===============================================================================================================


    //----------------------------GET BARCODE CODE FROM VIEWMODEL-----------------------------------

    private fun getBarCode() {
        scanViewModel.getBarcodeNumber().observe(viewLifecycleOwner, Observer { t ->
            if (t != null) {
                Log.d("TAG", t)
                barcodeET.setText(t)
                showFoodDetailsButton.performClick()
            } else {
                Log.d("TAG", "BRAK")
            }
        })
    }

    //==============================================================================================


    //----------------------SET ANIMATIONS ON LABEL WHICH IS ON BARCODE (LIKE SCAN ANIMATION)-------------------------

    private fun showScanLabelAnimation() {
        try {
            setAnim(scanLabel, 1500, 200f)
            handler.postDelayed({ setAnim(scanLabel, 2000, -200f) }, 750)
            handler.postDelayed({ setAnim(scanLabel, 2000, 200f) }, 1750)
            handler.postDelayed({ setAnim(scanLabel, 2000, -200f) }, 2750)
        } catch (ex: Exception) { }
    }

    //==================================================================================================================


    //-------------------OBJECT TRANSFORM ANIMATION--------------------------

    private fun setAnim(v: View, durationTime: Long, value: Float) {
        ObjectAnimator.ofFloat(v, "translationY", value).apply {
            duration = durationTime
            start()
        }
    }

    //========================================================================

    //----------GET FOOD INFO FROM JSON FUNCTION AND GO TO NEXT SCREEN WHEN THE INFO WAS GOT----------------

    private fun getFoodInfo(foodBarcodeNumber:String) {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                food = RetrofitClient.instance.getFoodAsync(foodBarcodeNumber).await().body()!!
                requireActivity().runOnUiThread {
                    var listOfAllergens = arrayListOf<String>()
                    if(food.product.allergensTags.isNotEmpty()) listOfAllergens = food.product.allergensTags.toList() as ArrayList<String>
                    foodInfoViewModel.setFood(SimplyfiFood(
                        food.product.productName,
                        food.product.productQuantity,
                        food.product.imageFrontUrl,
                        food.product.nutriments.energyKcal,
                        food.product.nutriments.carbohydrates,
                        food.product.nutriments.proteins,
                        food.product.nutriments.fat,
                        food.product.ingredients as ArrayList<Ingredient>,
                        food.product.categoriesTags as ArrayList<String>,
                        listOfAllergens))
                    handler.postDelayed({findNavController().navigate(R.id.action_scanFragment_to_foodDetailsFragment)},3000)
                }
            }
        }catch (ex:Exception){ }
    }

    //=======================================================================================================



    override fun onPause() {
        super.onPause()
        handler.removeCallbacksAndMessages(null) //REMOVE ALL CALLBACKS FROM HANDLER
    }
}