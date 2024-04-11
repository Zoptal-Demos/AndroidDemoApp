package com.zoptal.munzul.view.home

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.zoptal.munzul.R
import com.zoptal.munzul.databinding.ActivityHomeBinding
import com.zoptal.munzul.view.addProperty.fragments.AddProperty


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    lateinit var sContext: Activity
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sContext = HomeActivity@ this
        handleBottomNavigation()
        clickHandler()
    }

    private fun handleBottomNavigation(){
        navController = findNavController(R.id.navHostFragment)
        binding.bottomNavView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener{_, destination, _ ->
            // react on change
            // you can check destination.id or destination.label and act based on that
            if (destination.id == R.id.home || destination.id == R.id.discover ||
                destination.id==R.id.chatList || destination.id==R.id.profile || destination.id == R.id.addProperty){
                binding.bottomNavView.visibility = View.VISIBLE
                binding.ivAddProperty.visibility = View.VISIBLE
            } else {
                binding.bottomNavView.visibility = View.GONE
                binding.ivAddProperty.visibility = View.GONE
            }
        }
    }

    private fun clickHandler(){
        binding.ivAddProperty.setOnClickListener {
            // Navigate to your fragment here
            navController.navigate(R.id.addProperty)
        }
    }
}