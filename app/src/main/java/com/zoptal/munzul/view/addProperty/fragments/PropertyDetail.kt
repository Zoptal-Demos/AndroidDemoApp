package com.zoptal.munzul.view.addProperty.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zoptal.munzul.R
import com.zoptal.munzul.databinding.ListYourPropertySecondBinding
import com.zoptal.munzul.databinding.PropertyDetailBinding

class PropertyDetail:Fragment() {


    lateinit var sContext: Activity
    private lateinit var binding: PropertyDetailBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PropertyDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * On View Created
     * */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sContext = requireActivity()
        clickHandler()

    }


    /**
     * Click Handler
     * */
    private fun clickHandler() {
        binding.btViewBid.setOnClickListener {
            // Do Navigation
        }
    }
}