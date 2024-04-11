package com.zoptal.munzul.view.chatList.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zoptal.munzul.databinding.ChatListingItemBinding

class ChatListAdapter (val requireActivity: Context, val list:ArrayList<String>): RecyclerView.Adapter<ChatListAdapter.ListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListAdapter.ListHolder {
        val binding =
            ChatListingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatListAdapter.ListHolder, position: Int) {
        Log.e("ListSize--> is" ,"hkh $list")

        val currentItem = list[position]

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ListHolder(val binding: ChatListingItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}


