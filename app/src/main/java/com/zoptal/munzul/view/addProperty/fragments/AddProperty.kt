package com.zoptal.munzul.view.addProperty.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zoptal.munzul.R
import com.zoptal.munzul.databinding.AddPropertyBinding
import com.zoptal.munzul.model.IntroData
import com.zoptal.munzul.view.addProperty.adapters.AddPropertyAdapter

class AddProperty: Fragment() {

    lateinit var sContext: Activity
    private lateinit var binding: AddPropertyBinding
    lateinit var addPropertAdapter: AddPropertyAdapter
    private var addPropertyList = ArrayList<IntroData>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AddPropertyBinding.inflate(inflater, container, false)
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
        addData()
        addPropertAdapter = AddPropertyAdapter(requireActivity(), addPropertyList)
        binding.rvProperty.adapter = addPropertAdapter
    }

   /**
    * Add Data To List
    * */

   private fun addData() {
        val propertyType1 = IntroData().apply {
            image = R.drawable.sale
            title = getString(R.string.for_sale)
            subTitle = getString(R.string.it_will_take_approximately_4_Minutes)
        }
        val propertyType2 = IntroData().apply {
            image = R.drawable.rent
            title = getString(R.string.for_rent)
            subTitle = getString(R.string.it_will_take_approximately_4_Minutes)
        }
        val propertyType3 = IntroData().apply {
            image = R.drawable.auction
            title = getString(R.string.for_auction)
            subTitle = getString(R.string.it_will_take_approximately_4_Minutes)
        }
        val propertyType4 = IntroData().apply {
            image = R.drawable.rental_auction
            title = getString(R.string.for_rental_auction)
            subTitle = getString(R.string.it_will_take_approximately_4_Minutes)
        }
        val propertyType5 = IntroData().apply {
            image = R.drawable.ruma
            title = getString(R.string.ruma)
            subTitle = getString(R.string.it_will_take_approximately_4_Minutes)
        }

        addPropertyList.add(propertyType1)
        addPropertyList.add(propertyType2)
        addPropertyList.add(propertyType3)
        addPropertyList.add(propertyType4)
        addPropertyList.add(propertyType5)
    }
    /**
     * Click Handler
     * */
    private fun clickHandler() {
//        binding.etLocation.setOnClickListener {
////            findNavController().navigate(R.id.action_introFragment_to_splash)
//        }
    }
}