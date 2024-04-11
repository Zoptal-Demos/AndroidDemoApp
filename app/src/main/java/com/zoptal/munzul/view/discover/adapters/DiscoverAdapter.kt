package com.zoptal.munzul.view.discover.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zoptal.munzul.databinding.PopularSearchesItemBinding

class DiscoverAdapter (val requireActivity: Context, val list:ArrayList<String>): RecyclerView.Adapter<DiscoverAdapter.ListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoverAdapter.ListHolder {
        val binding =
            PopularSearchesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListHolder(binding)
    }

    override fun onBindViewHolder(holder: DiscoverAdapter.ListHolder, position: Int) {
        Log.e("ListSize--> is" ,"hkh $list")

        val currentItem = list[position]


    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ListHolder(val binding: PopularSearchesItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}


