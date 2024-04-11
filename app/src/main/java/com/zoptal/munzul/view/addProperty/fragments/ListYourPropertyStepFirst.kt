package com.zoptal.munzul.view.addProperty.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zoptal.munzul.R
import com.zoptal.munzul.databinding.ListYourPropertyFirstBinding
import com.zoptal.munzul.model.IntroData
import com.zoptal.munzul.view.addProperty.adapters.AddPropertyAdapter

class ListYourPropertyStepFirst: Fragment() {


    lateinit var sContext: Activity
    private lateinit var binding: ListYourPropertyFirstBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ListYourPropertyFirstBinding.inflate(inflater, container, false)
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
        binding.btNext.setOnClickListener {
            findNavController().navigate(R.id.action_listYourPropertyStepFirst_to_listYourPropertyStepSecond)
        }
    }
}