package com.example.foodpoint.screens

import android.R.attr.delay
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
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

    private val handler = Handler()

    //-----------------------------AUTO SCROLL IN VIEWPAGER----------------------------------
    private var autoPageScroll: Runnable = object : Runnable {
        override fun run() {
            val currentPage = welcomeViewPager.currentItem
            if(currentPage == welcomeViewPager.childCount){
                welcomeViewPager.setCurrentItem(0,true)
            }else{
                welcomeViewPager.setCurrentItem(currentPage+1,true)
            }
            handler.postDelayed(this,2000)
        }
    }
    //======================================================================================


    companion object{
        const val CAMERA_PERMISSION_REQUEST_CODE = 1234
    }

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
        setDarkMode()
    }


    //----------------------------SET MODE SAVED IN SHARED PREFERENCES DARK/LIGHT---------------------------
    private fun setDarkMode(){
        val darkModeStateSP = requireActivity().getSharedPreferences("DARK_MODE", Context.MODE_PRIVATE)
        if(darkModeStateSP.getBoolean("isDark",false)) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
    //=======================================================================================================

    //------------------GET CAMERA PERMISSION IF IT ISN'T GRANTED-----------------------
    private fun getCameraPermission(){
        if(Build.VERSION.SDK_INT>=23){
            if(ContextCompat.checkSelfPermission(requireContext(),android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                return requestPermissions(arrayOf(android.Manifest.permission.CAMERA),CAMERA_PERMISSION_REQUEST_CODE)
            }
        }
    }
    //==================================================================================

    //-----------------------INFINITY GET PERMISSION--------------------------
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == CAMERA_PERMISSION_REQUEST_CODE){
            if(grantResults[0] != PackageManager.PERMISSION_GRANTED){
                getCameraPermission()
            }
        }
    }
    //=========================================================================



    //-------------------SETUP VIEWPAGER IN WELCOME FRAGMENT BY PASS DATA IN IT---------------------
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

        handler.postDelayed(autoPageScroll,2000)

        startButton.setOnClickListener {
            getCameraPermission()
            findNavController().navigate(R.id.action_welcomeFragment_to_homeFragment)
        }

    }
    //===========================================================================================================



    override fun onStop() {
        super.onStop()
        handler.removeCallbacks(autoPageScroll)
    }

}

