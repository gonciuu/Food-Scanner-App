package com.example.foodpoint.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.foodpoint.R
import com.example.foodpoint.api.food_class.Food
import com.example.foodpoint.api.service.RetrofitClient
import com.example.foodpoint.classes.ViewPagerCard
import com.example.foodpoint.screens.adapters.pagers.WelcomePagerAdapter
import kotlinx.android.synthetic.main.fragment_welcome.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()
        getApi()
    }
    

    private fun getApi() {
        var food: Food? = null
        CoroutineScope(Dispatchers.IO).launch {
            try {
                food = RetrofitClient.instance.getFoodAsync().await().body()
                Log.d("TAG", food!!.product.productName)
            } catch (ex: Exception) {
                Log.d("TAG", ex.message!!)
            }
        }
    }

    private fun setupViewPager() {
        val listOfPagerCard = arrayListOf<ViewPagerCard>(
            ViewPagerCard(
                "Welcome to Food Point",
                "Please give access your camera so that we can scan and provide you that what\nis inside the food"
            ),
            ViewPagerCard(
                "Simply get food data",
                "Simply scan your food barcode and get information about us ingredients\nnutrition and etc... "
            ),
            ViewPagerCard(
                "Get health's nutrition",
                "In that app you can get information about if scaned food is t\n healthy or not"
            )
        )

        welcomeViewPager.adapter = WelcomePagerAdapter(context, listOfPagerCard)
        welcomePagerDots.setupWithViewPager(welcomeViewPager)
        welcomeViewPager.invalidate()


        for (i in 0 until welcomePagerDots.tabCount) {
            val tab = (welcomePagerDots.getChildAt(0) as ViewGroup).getChildAt(i)
            (tab.layoutParams as ViewGroup.MarginLayoutParams).setMargins(0, 0, 30, 0);
            tab.requestLayout()
        }

        startButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_homeFragment)
        }

    }
}

