package com.example.foodpoint.screens

import android.os.Bundle
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
        scanViewModel.getBarcodeNumber().observe(viewLifecycleOwner, Observer {
            t->
            if(t!=null){
                Log.d("TAG",t)
            }else{
                Log.d("TAG","BRAK")
            }
        })

        button.setOnClickListener {
            findNavController().navigate(R.id.action_scanFragment_to_foodDetailsFragment)
        }

        scanImage.setOnClickListener {
            findNavController().navigate(R.id.action_scanFragment_to_scanBarcodeCameraViewFragment)
        }
    }
}