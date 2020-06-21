package com.example.foodpoint.screens.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScanViewModel : ViewModel() {

    private val scanBarcodeNumber = MutableLiveData<String>()


    fun setBarcodeNumber(code:String){
        scanBarcodeNumber.value = code
    }

    fun getBarcodeNumber() : LiveData<String> = scanBarcodeNumber


}