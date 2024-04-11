package com.zoptal.munzul.view.profile.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zoptal.munzul.R
import com.zoptal.munzul.databinding.ProfileBinding

class Profile: Fragment() {


    lateinit var sContext: Activity
    private lateinit var binding: ProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sContext = requireActivity()
        clickHandler()

    }



    /**
     * Click Handler
     * */
    private fun clickHandler() {
        binding.clProfile.setOnClickListener {
            findNavController().navigate(R.id.action_profile_to_myProfile)
        }
        binding.tvMyProperties.setOnClickListener {
            findNavController().navigate(R.id.action_profile_to_myProperties)
        }
        binding.tvMyBiddings.setOnClickListener {
            findNavController().navigate(R.id.action_profile_to_myBiddings)
        }
        binding.tvHistory.setOnClickListener {
            findNavController().navigate(R.id.action_profile_to_myHistory)
        }
        binding.tvTransactionHistory.setOnClickListener {
            findNavController().navigate(R.id.action_profile_to_walletHistory)
        }
        binding.tvAdditionalInfo.setOnClickListener {
            findNavController().navigate(R.id.action_profile_to_additionalInformation)
        }
    }
}