package com.example.foodpoint.screens

import android.app.Activity
import android.os.Bundle
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView

class CameraScanView:Activity(), ZXingScannerView.ResultHandler{

    private lateinit var  mScannerView: ZXingScannerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mScannerView = ZXingScannerView(this)
        setContentView(mScannerView)
    }

    override fun handleResult(rawResult: Result?) {
        //TODO("Not yet implemented")
    }
}