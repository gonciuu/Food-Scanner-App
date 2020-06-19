package com.example.foodpoint.screens.adapters.recycler_views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodpoint.R

class PopularFoodAdapter():RecyclerView.Adapter<PopularFoodsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularFoodsViewHolder {
        return PopularFoodsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.popular_food_card,parent,false))
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: PopularFoodsViewHolder, position: Int) {
    }


}
class PopularFoodsViewHolder(view :View) :RecyclerView.ViewHolder(view){

}