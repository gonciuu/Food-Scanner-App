package com.example.foodpoint.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.DialogFragment
import com.example.foodpoint.R
import java.lang.Exception

class ListViewDialog(private val sharedPrefs:SharedPreferences,private val title: String, private val items: Array<String>,private val chooseLanguage:String) :
    DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return requireActivity().let {
            AlertDialog.Builder(context, R.style.MyDialogTheme).setTitle(title)
                .setSingleChoiceItems(
                    items,
                    items.indexOf(chooseLanguage),
                    DialogInterface.OnClickListener { dialogInterface, i ->
                        try {
                            sharedPrefs.edit().apply {
                            putString("lang",items[i])
                            apply()
                        }
                            Handler().postDelayed( {dialogInterface.dismiss()},200)
                        }catch (ex:Exception){ }
                    }).create()
        }
    }
}