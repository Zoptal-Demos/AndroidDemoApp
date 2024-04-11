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
import com.zoptal.munzul.databinding.SetNewPasswordBinding

class SetNewPassword: Fragment() {
    lateinit var sContext: Activity
    private lateinit var binding: SetNewPasswordBinding
    private var fromSignUp : Boolean = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SetNewPasswordBinding.inflate(inflater, container, false)
        binding.topLayout.tvTopHeading.text = getString(R.string.set_new_password)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fromSignUp = arguments?.getBoolean("fromSignUp")?:false
        sContext = requireActivity()
        clickHandler()

    }

    private fun clickHandler() {
        binding.btSetPassword.setOnClickListener {
                findNavController().navigate(R.id.action_setNewPassword_to_signIn)

        }
    }
}