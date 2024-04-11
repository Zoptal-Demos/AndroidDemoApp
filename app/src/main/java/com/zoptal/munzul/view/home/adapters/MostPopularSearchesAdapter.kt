package com.zoptal.munzul.view.home.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.zoptal.munzul.databinding.PopularSearchesItemBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MostPopularSearchesAdapter (val requireActivity: Context, val list:ArrayList<String>): RecyclerView.Adapter<MostPopularSearchesAdapter.ListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPopularSearchesAdapter.ListHolder {
        val binding= PopularSearchesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListHolder(binding)
    }

    override fun onBindViewHolder(holder: MostPopularSearchesAdapter.ListHolder, position: Int) {
        val currentItem=list[position]


    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ListHolder(val binding: PopularSearchesItemBinding): RecyclerView.ViewHolder(binding.root)



}