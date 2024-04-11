package com.zoptal.munzul.view.profile.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zoptal.munzul.databinding.WalletBalnceBinding
import com.zoptal.munzul.view.profile.adapters.WalletTransactionHistoryAdapter

class WalletHistory: Fragment() {


    lateinit var sContext: Activity
    private lateinit var binding: WalletBalnceBinding
    private lateinit var transactionHistoryAdapter: WalletTransactionHistoryAdapter
    private var transactionHistoryList = ArrayList<String>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WalletBalnceBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * On View Created
     * */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapters()
        sContext = requireActivity()
        clickHandler()

    }

    /**
     * Set Adapters
     * */
    private fun setAdapters(){
        transactionHistoryList.add("")
        transactionHistoryList.add("")
        transactionHistoryList.add("")
        transactionHistoryAdapter = WalletTransactionHistoryAdapter(requireActivity(), transactionHistoryList)
        binding.rvTransactionHistory.adapter = transactionHistoryAdapter
    }

    /**
     * Click Handler
     * */
    private fun clickHandler() {
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}