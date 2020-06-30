package com.example.foodpoint.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodpoint.R
import com.example.foodpoint.api.food_class.Ingredient
import com.example.foodpoint.api.food_class.food_class_to_communicate_wwith_others.SimplyfiFood
import com.example.foodpoint.api.service.RetrofitClient
import com.example.foodpoint.dialogs.DialogAlert
import com.example.foodpoint.screens.adapters.recycler_views.PopularFoodAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import kotlin.random.Random

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerViewAdapter()
        setBottomBarButtonsClick()
        getListOfFood()
    }


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

    private fun setRecyclerViewAdapter() {
        popularFoodsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = PopularFoodAdapter()
        }
    }

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
            }

        }

    }

    private fun showDialog(title:String,message:String){
            DialogAlert(title, message).show(requireActivity().supportFragmentManager, "error")
    }

}


