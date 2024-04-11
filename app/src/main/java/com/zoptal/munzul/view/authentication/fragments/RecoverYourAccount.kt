package com.zoptal.munzul.view.authentication.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zoptal.munzul.R
import com.zoptal.munzul.databinding.RecoverYourAccountBinding

class RecoverYourAccount: Fragment() {

    lateinit var sContext: Activity
    private lateinit var binding: RecoverYourAccountBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RecoverYourAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sContext = requireActivity()
        clickHandler()

    }

    private fun clickHandler() {
        binding.btSendOtp.setOnClickListener {
            findNavController().navigate(R.id.action_recoverYourAccount_to_verifyOtp)
        }
    }

}