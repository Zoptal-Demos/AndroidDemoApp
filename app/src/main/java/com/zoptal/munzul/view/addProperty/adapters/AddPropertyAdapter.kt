package com.zoptal.munzul.view.addProperty.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zoptal.munzul.R
import com.zoptal.munzul.databinding.PropertyTypeItemBinding
import com.zoptal.munzul.model.IntroData

class AddPropertyAdapter (val requireActivity: Context, val list:ArrayList<IntroData>): RecyclerView.Adapter<AddPropertyAdapter.ListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddPropertyAdapter.ListHolder {
        val binding =
            PropertyTypeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListHolder(binding)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: AddPropertyAdapter.ListHolder, position: Int) {

        val currentItem = list[position]
        holder.binding.tvForSale.text = currentItem.title.orEmpty()
        holder.binding.tvDescription.text = currentItem.subTitle.orEmpty()
            Glide.with(requireActivity).load(currentItem.image)
                .placeholder(R.drawable.sale).into(holder.binding.ivProperty)

        holder.itemView.setOnClickListener {
            holder.itemView.findNavController().navigate(R.id.action_addProperty_to_listYourPropertyStepFirst)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ListHolder(val binding: PropertyTypeItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}
