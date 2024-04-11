package com.zoptal.munzul.view.profile.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zoptal.munzul.databinding.MyHistoryBinding
import com.zoptal.munzul.view.profile.adapters.MyHistoryAdapter

class MyHistory: Fragment() {


    lateinit var sContext: Activity
    private lateinit var binding: MyHistoryBinding
    lateinit var myHistoryAdapter: MyHistoryAdapter
    private var myHistoryList = ArrayList<String>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MyHistoryBinding.inflate(inflater, container, false)
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
        myHistoryList.add("")
        myHistoryList.add("")
        myHistoryList.add("")
        myHistoryAdapter = MyHistoryAdapter(requireActivity(), myHistoryList)
        binding.rvHistory.adapter = myHistoryAdapter
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