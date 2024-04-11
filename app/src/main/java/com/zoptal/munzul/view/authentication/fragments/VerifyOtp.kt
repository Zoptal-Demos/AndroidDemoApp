package com.zoptal.munzul.view.authentication.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zoptal.munzul.R
import com.zoptal.munzul.databinding.VerifyOtpBinding
import com.zoptal.munzul.view.home.HomeActivity

class VerifyOtp: Fragment() {

    lateinit var sContext: Activity
    private lateinit var binding: VerifyOtpBinding
    private var fromSignUp : Boolean = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = VerifyOtpBinding.inflate(inflater, container, false)
        binding.topLayout.tvTopHeading.text = getString(R.string.verify_OTP)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fromSignUp = arguments?.getBoolean("fromSignUp")?:false
        sContext = requireActivity()
        clickHandler()

    }

    private fun clickHandler() {
        binding.btSubmit.setOnClickListener {
            if (fromSignUp){
                val intent = Intent(requireContext(), HomeActivity::class.java)
                startActivity(intent)
            }
            else{
                findNavController().navigate(R.id.action_verifyOtp_to_setNewPassword)
            }
        }
    }

}