package com.example.foodpoint.screens

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.findNavController
import com.example.foodpoint.R
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : Fragment() {

    private lateinit var  darkModeStateSP :SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        darkModeStateSP = requireActivity().getSharedPreferences("DARK_MODE", Context.MODE_PRIVATE)

        nightMode.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_homeFragment)
        }

        settingsBackButton.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_homeFragment)
        }
        setDarkThemeOnSwitch()
        darkThemeSwitch.isChecked = getDarkModeActualState()

    }


    private fun getDarkModeActualState() : Boolean = darkModeStateSP.getBoolean("isDark",false)


    private fun setDarkThemeOnSwitch(){
        darkThemeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                darkModeStateSP.edit().putBoolean("isDark",true).apply()
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else {
                darkModeStateSP.edit().putBoolean("isDark",false).apply()
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}