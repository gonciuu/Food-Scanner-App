package com.example.foodpoint.screens.adapters.recycler_views

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Matrix
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.foodpoint.R
import com.example.foodpoint.api.food_class.food_class_to_communicate_wwith_others.SimplyfiFood
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.popular_food_card.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PopularFoodAdapter(private val listOfFood:ArrayList<SimplyfiFood>,private val activity:FragmentActivity):RecyclerView.Adapter<PopularFoodsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularFoodsViewHolder {
        return PopularFoodsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.popular_food_card,parent,false))
    }

    override fun getItemCount(): Int {
        return listOfFood.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PopularFoodsViewHolder, position: Int) {
        holder.foodName.text = listOfFood[holder.adapterPosition].name
        setImage(listOfFood[holder.adapterPosition].imageUrl,holder.foodImage,activity)
        listOfFood[holder.adapterPosition].ingredients.forEach {
            holder.foodIngredients.text = holder.foodIngredients.text.toString() + it.text.removeSuffix("_").removePrefix("_") + ", "
        }
    }


}
class PopularFoodsViewHolder(view :View) :RecyclerView.ViewHolder(view){
    val foodName = view.popularFoodName!!
    val foodImage = view.popularFoodImage!!
    val foodIngredients = view.popularFoodIngredients!!
    val checkButton = view.popularCheckButton!!
}

private fun setImage(url:String,imageView:ImageView,activity: FragmentActivity){
    CoroutineScope(Dispatchers.IO).launch{
        var image = Picasso.get().load(url).get()
        if(image.width > image.height){
            val matrix : Matrix? = Matrix()
            matrix?.postRotate(90f)
            image = Bitmap.createBitmap(image,0,0,image.width,image.height,matrix,true)
        }
        activity.runOnUiThread {
            imageView.setImageBitmap(image)
        }
    }
}