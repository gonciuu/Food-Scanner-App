package com.example.foodpoint.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException

class DialogAlert(private val title:String,private val message:String) : DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return requireActivity().let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(title).setMessage(message).setNeutralButton(
                "OK",DialogInterface.OnClickListener{dialog,id->}
            )
            builder.create()
        }?:throw IllegalStateException("Activity cannot be null")
    }
}