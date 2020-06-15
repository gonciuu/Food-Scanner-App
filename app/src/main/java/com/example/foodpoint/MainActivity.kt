package com.example.foodpoint

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.foodpoint.classes.ViewPagerCard
import com.example.foodpoint.screens.adapters.WelcomePagerAdapter
import kotlinx.android.synthetic.main.fragment_welcome.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_welcome)
    }

    override fun onResume() {
        super.onResume()

        val listOfPagerCard = arrayListOf<ViewPagerCard>(
            ViewPagerCard("Welcome to Food Point","Please give access your camera so that we can scan and provide you that what\nis inside the food"),
            ViewPagerCard("Simply get food data","Simply scan your food barcode and get information about us ingredients\nnutrition and etc... "),
            ViewPagerCard("Get health's nutrition","In that app you can get information about if scaned food is t\n healthy or not")
        )

        welcomeViewPager.adapter = WelcomePagerAdapter(applicationContext,listOfPagerCard)
        welcomePagerDots.setupWithViewPager(welcomeViewPager)
        welcomeViewPager.invalidate()




        for (i in 0 until welcomePagerDots.tabCount) {
            val tab = (welcomePagerDots.getChildAt(0) as ViewGroup).getChildAt(i)
            (tab.layoutParams as ViewGroup.MarginLayoutParams).setMargins(0, 0, 30, 0);
            tab.requestLayout()
        }
    }
}