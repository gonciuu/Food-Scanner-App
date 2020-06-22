package com.example.foodpoint.screens

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.foodpoint.R
import com.example.foodpoint.screens.view_models.ScanViewModel
import kotlinx.android.synthetic.main.fragment_scan.*


class ScanFragment : Fragment() {
    private lateinit var scanViewModel:ScanViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_scan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scanViewModel = ViewModelProvider(requireActivity()).get(ScanViewModel::class.java)

        getBarCode()
        setupFragment()

    }


    private fun getBarCode(){
        scanViewModel.getBarcodeNumber().observe(viewLifecycleOwner, Observer {
                t->
            if(t!=null){
                Log.d("TAG",t)
                barcodeET.setText(t)
                showFoodDetailsButton.performClick()
            }else{
                Log.d("TAG","BRAK")
            }
        })
    }

    private fun setupFragment(){
        showFoodDetailsButton.setOnClickListener {
            showScanLabelAnimation()
            Handler().postDelayed({findNavController().navigate(R.id.action_scanFragment_to_foodDetailsFragment)},4000)
        }

        scanImage.setOnClickListener {
            findNavController().navigate(R.id.action_scanFragment_to_scanBarcodeCameraViewFragment)
        }
    }

    private fun showScanLabelAnimation(){
        try{
            setAnim(scanLabel,1500,200f)
            Handler().postDelayed({setAnim(scanLabel,2000,-200f)},750)
            Handler().postDelayed({setAnim(scanLabel,2000,200f)},1750)
            Handler().postDelayed({setAnim(scanLabel,2000,-200f)},2750)
        }catch (ex:Exception){

        }

    }


    private fun setAnim(v:View,durationTime:Long,value:Float){
        ObjectAnimator.ofFloat(v, "translationY", value).apply {
            duration = durationTime
            start()
        }
    }

}