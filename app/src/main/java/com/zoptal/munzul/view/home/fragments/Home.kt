package com.zoptal.munzul.view.home.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zoptal.munzul.databinding.HomeBinding
import com.zoptal.munzul.view.home.adapters.MostPopularSearchesAdapter

class Home: Fragment() {

    lateinit var sContext: Activity
    private lateinit var binding: HomeBinding
    private var titleList = arrayOf("                       Buy           ", "           Rent                      ")
    lateinit var mostPopularSearchAdapter: MostPopularSearchesAdapter
    private var mostPopularSearchList = ArrayList<String>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        for (title in titleList) {
            val tab = binding.tabLayout2.newTab()
            tab.text = title
            binding.tabLayout2.addTab(tab)
        }
        setAdapters()
        sContext = requireActivity()
        clickHandler()

    }

    /**
     * Set Adapters
     * */
    private fun setAdapters(){
        mostPopularSearchList.add("")
        mostPopularSearchList.add("")
        mostPopularSearchList.add("")
        mostPopularSearchAdapter = MostPopularSearchesAdapter(requireActivity(), mostPopularSearchList)
        binding.rvPopular.adapter = mostPopularSearchAdapter
    }

    /**
     * Click Handler
     * */
    private fun clickHandler() {
        binding.btSearch.setOnClickListener {
//            findNavController().navigate(R.id.action_introFragment_to_splash)
        }
    }




}