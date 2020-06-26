package com.example.foodpoint.screens

import android.graphics.Color
import android.os.Bundle
import android.text.format.DateUtils
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

    private lateinit var listOfSearchHistory : ArrayList<SimplyfiFood>

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
            listOfSearchHistory = t as ArrayList<SimplyfiFood>
            historyRecyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = HistoryRecyclerViewAdapter(listOfSearchHistory)
                setHistoryTimeButtons()
            }
        })
    }

    private fun setHistoryTimeButtons(){

        todayButton.setOnClickListener {
            setColors("#E4E4E4","#FE7D55","#313131","#ffffff")
            val listOfTodaySearch = arrayListOf<SimplyfiFood>()
            listOfSearchHistory.forEach {
                if(DateUtils.isToday(it.searchDate)){
                    listOfTodaySearch.add(it)
                }
            }
            historyRecyclerView.adapter = HistoryRecyclerViewAdapter(listOfTodaySearch)
        }

        allButton.setOnClickListener {
            setColors("#FE7D55","#E4E4E4","#ffffff","#313131")
            historyRecyclerView.adapter = HistoryRecyclerViewAdapter(listOfSearchHistory)
        }
    }


    private fun setColors(allButtonTint:String,todayButtonTint:String, allButtonTextColor:String,todayButtonTextColor:String){
        allButton.background.setTint(Color.parseColor(allButtonTint))
        todayButton.background.setTint(Color.parseColor(todayButtonTint))
        todayButton.setTextColor(Color.parseColor(todayButtonTextColor))
        allButton.setTextColor(Color.parseColor(allButtonTextColor))
    }
}