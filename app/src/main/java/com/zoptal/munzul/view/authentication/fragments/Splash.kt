package com.zoptal.munzul.view.authentication.fragments

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.zoptal.munzul.R

class Splash : Fragment() {
    lateinit var sContext: Activity


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.splash, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            sContext = requireActivity()
            navigateToNextScreenWithDelay(3000)


        }catch (e:Exception){
          Toast.makeText(requireActivity(),"Exception"+e.message,Toast.LENGTH_SHORT).show()
        }

    }

    private fun navigateToNextScreenWithDelay(delayMillis: Long) {
        // Delay navigation by the specified time
        Handler(Looper.getMainLooper()).postDelayed({
            // Navigate to the next screen
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.splash, true)
                .build()
            findNavController().navigate(R.id.action_splash_to_introFragment)
        }, delayMillis)
    }


}