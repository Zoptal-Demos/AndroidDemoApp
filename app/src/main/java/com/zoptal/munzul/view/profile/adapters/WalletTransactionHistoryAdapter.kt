package com.zoptal.munzul.view.profile.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zoptal.munzul.databinding.WalletTransactionsItemBinding

class WalletTransactionHistoryAdapter (val requireActivity: Context, val list:ArrayList<String>): RecyclerView.Adapter<WalletTransactionHistoryAdapter.ListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletTransactionHistoryAdapter.ListHolder {
        val binding= WalletTransactionsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListHolder(binding)
    }

    override fun onBindViewHolder(holder: WalletTransactionHistoryAdapter.ListHolder, position: Int) {
        val currentItem=list[position]
//        holder.binding.nameTV.text = currentItem.fullName.orEmpty()
//        if (!currentItem.profile_pic.isNullOrEmpty()){
//            Glide.with(requireActivity).load(ApiConstants.IMAGE_URL +currentItem.profile_pic)
//                .placeholder(R.drawable.image).into(holder.itemView.profileIV)
//        }




//        holder.itemView.rateTV.setOnClickListener {
//            val bundle= Bundle()
//            bundle.putString("id",currentItem.userId)
//            bundle.putString("userName",currentItem.fullName)
//            holder.itemView.findNavController().navigate(R.id.eventDetailFragment_to_rateUsers,bundle)
//
//        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ListHolder(val binding: WalletTransactionsItemBinding): RecyclerView.ViewHolder(binding.root)



}