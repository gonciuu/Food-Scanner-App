package com.example.foodpoint

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
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
        welcomePagerDots.setupWithViewPager(welcomeViewPager)
        welcomeViewPager.invalidate()
        for (i in 0 until welcomePagerDots.getTabCount()) {
            val tab = (welcomePagerDots.getChildAt(0) as ViewGroup).getChildAt(i)
            (tab.layoutParams as ViewGroup.MarginLayoutParams).setMargins(0, 0, 30, 0);
            tab.requestLayout()
        }
    }
}