package com.example.foodpoint.screens.adapters.recycler_views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodpoint.R
import com.example.foodpoint.api.food_class.food_class_to_communicate_wwith_others.SimplyfiFood

class PopularFoodAdapter(val listOfFood:ArrayList<SimplyfiFood>):RecyclerView.Adapter<PopularFoodsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularFoodsViewHolder {
        return PopularFoodsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.popular_food_card,parent,false))
    }

    override fun getItemCount(): Int {
        return listOfFood.size
    }

    override fun onBindViewHolder(holder: PopularFoodsViewHolder, position: Int) {
    }


}
class PopularFoodsViewHolder(view :View) :RecyclerView.ViewHolder(view){

}