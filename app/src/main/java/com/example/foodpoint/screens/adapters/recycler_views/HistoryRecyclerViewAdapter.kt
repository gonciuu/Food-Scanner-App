package com.example.foodpoint.screens.adapters.recycler_views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodpoint.R

class HistoryRecyclerViewAdapter():RecyclerView.Adapter<HistoryViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
       return HistoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.history_card,parent,false))
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
    }


}
class HistoryViewHolder(view :View) :RecyclerView.ViewHolder(view){

}