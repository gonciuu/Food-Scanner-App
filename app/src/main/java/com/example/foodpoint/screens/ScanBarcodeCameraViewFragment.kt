package com.example.foodpoint.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.foodpoint.R
import com.example.foodpoint.screens.view_models.ScanViewModel
import com.google.zxing.Result
import kotlinx.android.synthetic.main.fragment_scan_barcode_camera_view.*
import me.dm7.barcodescanner.zxing.ZXingScannerView


class ScanBarcodeCameraViewFragment : Fragment(),ZXingScannerView.ResultHandler {

    private lateinit var scanViewModel: ScanViewModel
    private var isFocus = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_scan_barcode_camera_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(savedInstanceState!=null){
            if(savedInstanceState.containsKey("isFocus")){
                isFocus = savedInstanceState.getBoolean("isFocus")
            }
        }
        scanViewModel = ViewModelProvider(requireActivity()).get(ScanViewModel::class.java)
        cameraButtonsFunctions()
    }



    override fun onResume() {
        super.onResume()
        scanBarcodeView.setResultHandler(this)
        scanBarcodeView.startCamera()
    }



    override fun handleResult(rawResult: Result?) {
        if(rawResult!=null){
            scanViewModel.setBarcodeNumber(rawResult.text)
            findNavController().navigate(R.id.action_scanBarcodeCameraViewFragment_to_scanFragment)
        }else{
            scanBarcodeView.resumeCameraPreview(this)
        }
    }

    override fun onPause() {
        super.onPause()
        scanBarcodeView.stopCamera()
    }


    private fun cameraButtonsFunctions(){
        focusButton.setOnClickListener {
            isFocus = !isFocus
            scanBarcodeView.setAutoFocus(isFocus)
            Log.d("TAG",isFocus.toString())
        }
        flashlightButton.setOnClickListener {
            scanBarcodeView.flash = !scanBarcodeView.flash
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("isFocus",isFocus)
    }
}