package com.example.foodpoint.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodpoint.R
import com.example.foodpoint.screens.adapters.recycler_views.PopularFoodAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerViewAdapter()
        setBottomBarButtonsClick()
    }


    private fun setBottomBarButtonsClick(){

        scanButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_scanFragment)
        }

        bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId){
                R.id.menuSettings->{
                    Log.d("TAG","settings")
                    true
                }
                else->{
                    Log.d("TAG","nic")
                    true
                }
            }
        }

        bottomAppBar.setNavigationOnClickListener {
            Log.d("TAG","archiwum ")
        }


    }

    private fun setRecyclerViewAdapter(){
        popularFoodsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = PopularFoodAdapter()
        }
    }
}