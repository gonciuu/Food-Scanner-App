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
import java.util.*


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
        setLocale()
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
        val lang = requireActivity().getSharedPreferences("OPTIONS", Context.MODE_PRIVATE).getString("lang","English")!!
        val listOfPagerCard = arrayListOf<ViewPagerCard>(
            ViewPagerCard(
                when(lang){
                    "English"->"Welcome to Food Point"
                    "Polish"->"Witaj w Food Point"
                    "Germany" -> "Wilkommen to Food Point"
                    else -> "Welcome to Food Point"
                },
                when(lang){
                    "English"->"Please give access your camera so that we can scan and provide you that what\nis inside the food"
                    "Polish"->"Prosimy o danie permisji do aparatu w celu możliwości skanowania kodu kreskowego"
                    "Germany" -> "Bitte geben Sie Zugriff auf Ihre Kamera, damit wir scannen und Ihnen das zur Verfügung stellen können\nist im Essen"
                    else -> "Please give access your camera so that we can scan and provide you that what\n" +
                            "is inside the food"
                }
            ),
            ViewPagerCard(
                when(lang){
                    "English"->"Simply get food data"
                    "Polish"->"Łatwe pozyskanie informacji o jedzeniu"
                    "Germany" -> "Holen Sie sich einfach Lebensmitteldaten"
                    else -> "Simply get food data"
                },
                when(lang){
                    "English"->  "Simply scan your food barcode and get information about us ingredients\nnutrition and etc... "
                    "Polish"->"Prosimy o danie permisji do aparatu w celu możliwości skanowania kodu kreskowego"
                    "Germany" -> "Scannen Sie einfach Ihren Lebensmittel-Barcode und erhalten Sie Informationen über uns Zutaten\n" +
                            "Ernährung und etc ..."
                    else -> "Simply scan your food barcode and get information about us ingredients nutrition and etc..."
                }

            ),
            ViewPagerCard(
                when(lang){
                    "English"-> "Get health's nutrition"
                    "Polish"->"Uzyskanie zdrowych składników produktu "
                    "Germany" -> "Holen Sie sich die Ernährung der Gesundheit"
                    else -> "Get health's nutrition"
                },
                when(lang){
                    "English"->   "In that app you can get information about if scaned food is \n healthy or not"
                    "Polish"->"W tej aplikacji możesz uzyskać informacje o tym, czy skanowana żywność\n" +
                            " jest zdrowa czy nie"
                    "Germany" -> "In dieser App können Sie Informationen darüber erhalten, ob gescannte Lebensmittel t sind\n gesund oder nicht"
                    else -> "In that app you can get information about if scaned food is \n" +
                            " healthy or not"
                }


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

    private fun setLocale(){
        var myLocale :Locale? = null
        when(requireActivity().getSharedPreferences("OPTIONS", Context.MODE_PRIVATE).getString("lang","English")!!){
            "Germany"-> myLocale = Locale("de")
            "English"->myLocale = Locale("en")
            "Polish"->myLocale = Locale("pl")
        }
        val res = resources
        val dm = res.displayMetrics
        val conf = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, dm)
    }

}

