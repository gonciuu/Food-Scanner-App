package com.example.foodpoint

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.foodpoint.screens.adapters.WelcomePagerAdapter
import kotlinx.android.synthetic.main.fragment_welcome.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_welcome)
    }

    override fun onResume() {
        super.onResume()
        welcomeViewPager.adapter = WelcomePagerAdapter(applicationContext)
        welcomeViewPager.invalidate()
    }
}