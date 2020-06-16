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
        setContentView(R.layout.activity_main)
    }
}