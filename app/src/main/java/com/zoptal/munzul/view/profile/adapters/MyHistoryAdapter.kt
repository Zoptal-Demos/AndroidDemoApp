package com.zoptal.munzul.view.profile.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zoptal.munzul.databinding.PopularSearchesItemBinding

class MyHistoryAdapter (val requireActivity: Context, val list:ArrayList<String>): RecyclerView.Adapter<MyHistoryAdapter.ListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHistoryAdapter.ListHolder {
        val binding= PopularSearchesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHistoryAdapter.ListHolder, position: Int) {
        val currentItem=list[position]

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ListHolder(val binding: PopularSearchesItemBinding): RecyclerView.ViewHolder(binding.root)



}