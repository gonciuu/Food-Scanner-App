package com.example.foodpoint.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.DialogFragment
import com.example.foodpoint.R
import java.util.*

class ListViewDialog(private val sharedPrefs:SharedPreferences,private val title: String, private val items: Array<String>,private val chooseLanguage:String) :
    DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return requireActivity().let {
            AlertDialog.Builder(context, R.style.MyDialogTheme).setTitle(title)
                .setSingleChoiceItems(
                    items,
                    items.indexOf(chooseLanguage),
                    DialogInterface.OnClickListener { dialogInterface, i ->
                        Log.d("NUMER",i.toString())
                            when(i){
                                0->setLang("de")
                                1->setLang("en")
                                2->setLang("pl")
                            }
                            sharedPrefs.edit().apply {
                            putString("lang",items[i])
                            apply()
                        }
                            Handler().postDelayed( {dialogInterface.dismiss()},200)
                    }).create()
        }
    }


    @Suppress("DEPRECATION")
    private fun setLang(countryCode:String){
        val myLocale = Locale(countryCode)
        val res = resources
        val dm = res.displayMetrics
        val conf = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, dm)
        requireActivity().onBackPressed()
    }
}

