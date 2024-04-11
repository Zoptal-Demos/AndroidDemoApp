package com.zoptal.munzul.view.profile.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zoptal.munzul.R
import com.zoptal.munzul.databinding.EditProfileBinding

class EditProfile: Fragment() {


    lateinit var sContext: Activity
    private lateinit var binding: EditProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EditProfileBinding.inflate(inflater, container, false)
        binding.topLayout.tvTopHeading.text = getString(R.string.edit_profile)
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
        binding.btUpdate.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.topLayout.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

    }
}