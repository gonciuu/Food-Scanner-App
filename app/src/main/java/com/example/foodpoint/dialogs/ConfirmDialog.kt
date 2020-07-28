package com.example.foodpoint.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.foodpoint.R
import com.example.foodpoint.history_database.HistoryViewModel
import java.util.*

class ConfirmDialog(private val title:String,private val message:String,private val historyViewModel: HistoryViewModel):DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return requireActivity().let {
            AlertDialog.Builder(requireContext(), R.style.MyDialogTheme)
                .setTitle(title).setMessage(message)
                .setPositiveButton("Confirm") { dialog, _ ->
                    historyViewModel.deleteAllHistory()
                    val myLocale = Locale("en")
                    val res = resources
                    val dm = res.displayMetrics
                    val conf = res.configuration
                    conf.locale = myLocale
                    res.updateConfiguration(conf, dm)
                    dialog.dismiss()
                    requireActivity().onBackPressed()
                }
                .setNegativeButton("Cancel") { dialogInterface, i ->
                    dialogInterface.dismiss()
                }
                .create()
        }
    }
}