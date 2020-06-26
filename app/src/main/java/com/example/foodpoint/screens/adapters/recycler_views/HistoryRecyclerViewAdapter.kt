package com.example.foodpoint.screens.adapters.recycler_views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodpoint.R
import com.example.foodpoint.api.food_class.food_class_to_communicate_wwith_others.SimplyfiFood
import com.example.foodpoint.history_database.HistoryViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_food_details.view.*
import kotlinx.android.synthetic.main.history_card.view.*

class HistoryRecyclerViewAdapter(private val listOfFoodHistory : ArrayList<SimplyfiFood>, private val historyViewModel: HistoryViewModel):RecyclerView.Adapter<HistoryViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
       return HistoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.history_card,parent,false))
    }

    override fun getItemCount(): Int {
        return listOfFoodHistory.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.foodName.text = listOfFoodHistory[holder.adapterPosition].name
        Picasso.get().load(listOfFoodHistory[holder.adapterPosition].imageUrl).into(holder.foodImage)
        holder.foodBarcodeNumber.text = listOfFoodHistory[holder.adapterPosition].urlId

        holder.deleteButton.setOnClickListener {
            historyViewModel.deleteHistory(listOfFoodHistory[holder.adapterPosition])
            listOfFoodHistory.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
        }
    }


}
class HistoryViewHolder(view :View) :RecyclerView.ViewHolder(view){
    val foodName = view.historyFoodName!!
    val foodBarcodeNumber = view.historyFoodNumber!!
    val foodImage = view.historyFoodImage!!
    val deleteButton = view.historyDeleteIcon!!
    val checkButton = view.historyCheckIcon!!
}