package com.example.foodpoint.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodpoint.R
import com.google.zxing.Result
import kotlinx.android.synthetic.main.fragment_scan_barcode_camera_view.*
import me.dm7.barcodescanner.zxing.ZXingScannerView


class ScanBarcodeCameraViewFragment : Fragment(),ZXingScannerView.ResultHandler {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_scan_barcode_camera_view, container, false)
    }

    override fun onResume() {
        super.onResume()
        scanBarcodeView.setResultHandler(this)
        scanBarcodeView.startCamera()
    }

    override fun handleResult(rawResult: Result?) {
        Log.v("TAG", rawResult?.text); // Prints scan results
        Log.v("TAG", rawResult?.barcodeFormat.toString()); // Prints the scan format (qrcode, pdf417 etc.)

        scanBarcodeView.resumeCameraPreview(this);
    }

    override fun onPause() {
        super.onPause()
        scanBarcodeView.stopCamera()
    }

}