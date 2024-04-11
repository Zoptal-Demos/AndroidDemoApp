package com.zoptal.munzul.view.profile.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zoptal.munzul.databinding.MyBiddingsBinding
import com.zoptal.munzul.view.profile.adapters.MyBiddingsAdapter

class MyBiddings: Fragment() {

    lateinit var sContext: Activity
    private lateinit var binding: MyBiddingsBinding
    lateinit var myBiddingsAdapter: MyBiddingsAdapter
    private var myBiddingsList = ArrayList<String>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MyBiddingsBinding.inflate(inflater, container, false)
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
        myBiddingsList.add("")
        myBiddingsList.add("")
        myBiddingsList.add("")
        myBiddingsAdapter = MyBiddingsAdapter(requireActivity(), myBiddingsList)
        binding.rvBiding.adapter = myBiddingsAdapter
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