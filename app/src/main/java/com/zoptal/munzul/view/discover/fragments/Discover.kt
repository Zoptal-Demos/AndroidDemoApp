package com.zoptal.munzul.view.discover.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zoptal.munzul.databinding.DiscoverBinding
import com.zoptal.munzul.view.discover.adapters.DiscoverAdapter

class Discover: Fragment() {


    lateinit var sContext: Activity
    private lateinit var binding: DiscoverBinding
    private lateinit var discoverAdapter: DiscoverAdapter
    private var discoverSearchList = ArrayList<String>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DiscoverBinding.inflate(inflater, container, false)
        return binding.root
    }

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
        discoverSearchList.add("")
        discoverSearchList.add("")
        discoverSearchList.add("")
        discoverAdapter = DiscoverAdapter(requireActivity(), discoverSearchList)
        binding.rvDiscover.adapter = discoverAdapter
    }

    /**
     * Click Handler
     * */
    private fun clickHandler() {
        binding.etLocation.setOnClickListener {
//            findNavController().navigate(R.id.action_introFragment_to_splash)
        }
    }
}