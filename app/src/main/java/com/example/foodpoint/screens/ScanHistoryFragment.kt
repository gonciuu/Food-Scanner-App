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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodpoint.R
import com.example.foodpoint.api.food_class.food_class_to_communicate_wwith_others.SimplyfiFood
import com.example.foodpoint.history_database.HistoryViewModel
import com.example.foodpoint.screens.adapters.recycler_views.HistoryRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_scan_history.*
import kotlinx.android.synthetic.main.fragment_settings.*

class ScanHistoryFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_scan_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scanHistoryBackButton.setOnClickListener {
            findNavController().navigate(R.id.action_scanHistoryFragment_to_homeFragment)
        }
        getAllHistory()
    }

    private fun getAllHistory(){
        val  historyViewModel = ViewModelProvider.AndroidViewModelFactory(requireActivity().application).create(HistoryViewModel::class.java)
        historyViewModel.allHistory.observe(viewLifecycleOwner, Observer {
                t->
            historyRecyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = HistoryRecyclerViewAdapter(t as ArrayList<SimplyfiFood>)
            }
        })
    }

}