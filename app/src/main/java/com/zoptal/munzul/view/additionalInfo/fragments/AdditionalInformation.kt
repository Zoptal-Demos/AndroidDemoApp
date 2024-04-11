package com.zoptal.munzul.view.additionalInfo.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zoptal.munzul.databinding.AdditionalInfoBinding

class AdditionalInformation: Fragment() {


    lateinit var sContext: Activity
    private lateinit var binding: AdditionalInfoBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AdditionalInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sContext = requireActivity()
        clickHandler()

    }

    private fun clickHandler() {
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.tvBasicInfo.setOnClickListener {
//            findNavController().navigate(R.id.action_signIn_to_recoverYourAccount)
        }
    }
}