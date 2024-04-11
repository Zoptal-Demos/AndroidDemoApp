package com.zoptal.munzul.view.profile.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zoptal.munzul.databinding.MyPropertiesBinding
import com.zoptal.munzul.view.profile.adapters.MyPropertiesAdapter

class MyProperties: Fragment() {


    lateinit var sContext: Activity
    private lateinit var binding: MyPropertiesBinding
    lateinit var myPropertiesAdapter: MyPropertiesAdapter
    private var myPropertiesList = ArrayList<String>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MyPropertiesBinding.inflate(inflater, container, false)
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
        myPropertiesList.add("")
        myPropertiesList.add("")
        myPropertiesList.add("")
        myPropertiesAdapter = MyPropertiesAdapter(requireActivity(), myPropertiesList)
        binding.rvChatListing.adapter = myPropertiesAdapter
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