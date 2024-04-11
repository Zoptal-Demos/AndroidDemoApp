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
import com.zoptal.munzul.databinding.SignInBinding
import com.zoptal.munzul.view.home.HomeActivity

class SignIn : Fragment() {

    lateinit var sContext: Activity
    private lateinit var binding: SignInBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sContext = requireActivity()
        clickHandler()

    }

    private fun clickHandler() {
        binding.btSignIn.setOnClickListener {
            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)
        }
        binding.tvForgot.setOnClickListener {
            findNavController().navigate(R.id.action_signIn_to_recoverYourAccount)
        }
        binding.tvSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_signIn_to_signUp)
        }
    }

}