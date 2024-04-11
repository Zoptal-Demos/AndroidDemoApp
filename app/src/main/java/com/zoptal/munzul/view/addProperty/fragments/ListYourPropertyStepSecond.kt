package com.zoptal.munzul.view.addProperty.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zoptal.munzul.R
import com.zoptal.munzul.databinding.ListYourPropertySecondBinding

class ListYourPropertyStepSecond: Fragment() {


    lateinit var sContext: Activity
    private lateinit var binding: ListYourPropertySecondBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ListYourPropertySecondBinding.inflate(inflater, container, false)
        binding.topLayout.tvTopHeading.text = getString(R.string.list_your_property_carefully)
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
        binding.btSubmit.setOnClickListener {
              // Do Navigation
        }
    }
}