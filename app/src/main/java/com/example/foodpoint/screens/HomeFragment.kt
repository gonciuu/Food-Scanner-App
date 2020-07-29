package com.example.foodpoint.screens

import android.annotation.SuppressLint
import android.content.Context.MODE_PRIVATE
import android.graphics.Bitmap
import android.graphics.Matrix
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodpoint.R
import com.example.foodpoint.api.food_class.Ingredient
import com.example.foodpoint.api.food_class.food_class_to_communicate_wwith_others.SimplyfiFood
import com.example.foodpoint.api.service.RetrofitClient
import com.example.foodpoint.dialogs.DialogAlert
import com.example.foodpoint.history_database.HistoryViewModel
import com.example.foodpoint.screens.adapters.recycler_views.PopularFoodAdapter
import com.example.foodpoint.screens.view_models.FoodInfoViewModel
import com.example.foodpoint.screens.view_models.HomeViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_food_details.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class HomeFragment : Fragment() {
    lateinit var foodInfoViewModel: FoodInfoViewModel
    lateinit var historyViewModel: HistoryViewModel
    private lateinit var homeViewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        foodInfoViewModel = ViewModelProvider(requireActivity()).get(FoodInfoViewModel::class.java)
        historyViewModel = ViewModelProvider.AndroidViewModelFactory(requireActivity().application).create(HistoryViewModel::class.java)
        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        setLoadingAdapter()
        setActualDate()
        setBottomBarButtonsClick()
        getListOfFood()
    }

    //--------------------SET ADAPTER TO RECYCLER VIEW AS "LOADING"-----------------------
    private fun setLoadingAdapter(){
        val isDark = requireActivity().getSharedPreferences("DARK_MODE",MODE_PRIVATE).getBoolean("isDark",false)
        if(isDark) randomFoodImage.setImageResource(R.drawable.camera_nightmode)

        popularFoodsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = PopularFoodAdapter(arrayListOf(),this@HomeFragment,isDark)
        }
    }
    //====================================================================================

    //----------------------SET ON CLICK ON BUTTONS IN BOTTOM BAR AND THE FLOATING ACTION BUTTON----------------------

    private fun setBottomBarButtonsClick() {

        scanButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_scanFragment)
        }

        bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menuSettings -> {
                    findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
                    true
                }
                else -> true
            }
        }

        bottomAppBar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_scanHistoryFragment)
        }

    }
    //==================================================================================================================


    //---------------------GET LIST OF SILMPLIFY FOOD FROM API FROM FOOD BARCODE IN LIST-------------------------
    private fun getListOfFood() {


        val foodsIdList = arrayListOf<String>("5906040063577", "4014400900576", "7613034944849", "5900084231145", "20142322", "5900512320359")

        val listOfFood = arrayListOf<SimplyfiFood>()

        CoroutineScope(Dispatchers.IO).launch {
            foodsIdList.forEach {
                try {
                    val food = RetrofitClient.instance.getFoodAsync(it).await().body()!!
                    if (food.status == 1) {
                        requireActivity().runOnUiThread {
                            var listOfAllergens = ArrayList<String>()
                            if (food.product.allergensTags.isNotEmpty()) listOfAllergens = food.product.allergensTags as ArrayList<String>
                            val simpleFood = SimplyfiFood(
                                food.product.id,
                                food.product.productName,
                                food.product.productQuantity,
                                food.product.imageFrontUrl,
                                food.product.nutriments.energyKcal,
                                food.product.nutriments.carbohydrates,
                                food.product.nutriments.proteins,
                                food.product.nutriments.fat,
                                food.product.ingredients as ArrayList<Ingredient>,
                                food.product.categoriesTags as ArrayList<String>,
                                listOfAllergens,
                                System.currentTimeMillis()
                            )
                            listOfFood.add(simpleFood)
                        }
                    }
                } catch (socketEx: SocketTimeoutException) {
                    showDialog(
                        "Error",
                        "Check your internet connection"
                    )        //no internet connection
                } catch (ex: java.lang.Exception) {
                    showDialog("Error", "Check your internet connection. Error ${ex.message}")
                }
            }
            requireActivity().runOnUiThread {
                val randomFood = listOfFood[Random.nextInt(0,5)]
                setRandomFoodInfoInUI(randomFood)
                listOfFood.remove(randomFood)
                setTopPopularFoodsAdapter(listOfFood)
                //homeViewModel.setFood(listOfFood)
            }

        }

    }

    //====================================================================================================================

    //--------------FUNCTION WHITCH SHOW CUSTOM ALERT DIALOG-------------------
    private fun showDialog(title:String,message:String){
        try{
            DialogAlert(title, message).show(requireActivity().supportFragmentManager, "error")
        }catch (ex:java.lang.Exception){}
    }
    //=========================================================================



    //-------------------------SETTING THE INFO ABOUT RANDOM FOOD IN UI IN HOME FRAGMENT-----------------------------
    @SuppressLint("SetTextI18n")
    private fun setRandomFoodInfoInUI(food: SimplyfiFood){
        try{
            randomFoodIngredients.text =""
            setImage(food.imageUrl)
            randomFoodName.text = food.name
            randomFoodCalories.text = "Calories : ${(food.calories * (food.quantity.toDouble()/100)).toInt()}"

            if(food.ingredients.isNotEmpty()){
                food.ingredients.forEach {
                    randomFoodIngredients.text = randomFoodIngredients.text.toString() + it.text.removePrefix("_").removeSuffix("_") + ", "
                }
            }else{
                randomFoodIngredients.text = "Cannot find ingredients in database"
            }

            randomFoodCheckButton.setOnClickListener {
                foodInfoViewModel.setFood(food)
                historyViewModel.insertHistory(food)
                findNavController().navigate(R.id.action_homeFragment_to_foodDetailsFragment)
            }
        }catch (ex : Exception){}

    }
    //=================================================================================================================


    //------------------SET FOOD ADPATER AFTER GET FOOD INFO FROM API-----------------------
    private fun setTopPopularFoodsAdapter(listOfFoods: ArrayList<SimplyfiFood>){
        try{
            popularFoodsRecyclerView.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = PopularFoodAdapter(listOfFoods,this@HomeFragment,null)
            }
        }catch (ex : java.lang.Exception){}
    }
    //=======================================================================================


    //-------------------------SET IMAGE AND IF THE WIDTH > HEIGHT ROTATE THIS PHOTO------------------------------

    private fun setImage(url:String){
        CoroutineScope(Dispatchers.IO).launch{
            try{
                var image = Picasso.get().load(url).get()
                if(image.width > image.height){
                    val matrix : Matrix? = Matrix()
                    matrix?.postRotate(90f)
                    image = Bitmap.createBitmap(image,0,0,image.width,image.height,matrix,true)
                }
                requireActivity().runOnUiThread {
                    if(randomFoodImage!=null) randomFoodImage.setImageBitmap(image)
                }
            }catch (ex:Exception){
                requireActivity().runOnUiThread {
                    randomFoodImage.setImageResource(R.drawable.camera)
                }
            }

        }
    }

    //=============================================================================================================

    //------------------SET ACTUAL DATE IN TEXTVIEW--------------------
    private fun setActualDate(){
        val sdf = SimpleDateFormat("EEE, d MMM", Locale.getDefault())
        actualDate.text = sdf.format(System.currentTimeMillis())
    }
    //=================================================================
}


