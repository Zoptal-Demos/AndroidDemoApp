package com.zoptal.munzul.view.authentication.fragments

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.zoptal.munzul.R
import com.zoptal.munzul.databinding.AppIntroBinding
import com.zoptal.munzul.model.IntroData
import com.zoptal.munzul.view.authentication.adapters.IntroAdapter

class IntroFragment : Fragment(){
    lateinit var sContext: Activity
    var current_pos: Int = 0
    var arrayList: ArrayList<IntroData> = ArrayList()
    private lateinit var binding: AppIntroBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AppIntroBinding.inflate(inflater, container, false)
        addData()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sContext = requireActivity()
        clickHandler()
        viewPager()

    }

    private fun clickHandler() {
        binding.tvSkip.setOnClickListener {
            findNavController().navigate(R.id.action_introFragment_to_signUp)
        }
        binding.tvNext.setOnClickListener {
            binding.viewPager.currentItem=current_pos+1
        }


        binding.btGetStarted.setOnClickListener {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.splash, true)
                .setPopUpTo(R.id.introFragment, true)
                .build()
            findNavController().navigate(R.id.action_introFragment_to_signUp)
        }

    }

    private fun addData() {
        arrayList.clear()
        val getDataModel = IntroData()
        getDataModel.title = resources.getString(R.string.welcome_to_munzul)
        getDataModel.subTitle = "Your Home, Your Way"
        getDataModel.image = R.drawable.onboarding_1
        arrayList.add(getDataModel)
        val getDataModel1 = IntroData()
        getDataModel1.title = resources.getString(R.string.explore_buy_rent)
        getDataModel1.subTitle = "We tango will verify health checkups before you’re meeting with someone. Your health is our most priority."
        getDataModel1.image = R.drawable.onboarding_2
        arrayList.add(getDataModel1)
        val getDataModel2 = IntroData()
        getDataModel2.title = resources.getString(R.string.your_journey_begins)
        getDataModel2.subTitle = "Find yourself someone who's always willing to ask for the perfect date with you."
        getDataModel2.image = R.drawable.onboarding_3
        arrayList.add(getDataModel2)

    }

    private fun viewPager() {
        try {
            val learnMoreAdapter = IntroAdapter(sContext, arrayList)
            binding.viewPager.adapter = learnMoreAdapter
            binding.dotsIndicator.setViewPager(binding.viewPager)
            binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

                override fun onPageScrollStateChanged(state: Int) {

                }
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                }
                override fun onPageSelected(position: Int) {
                    current_pos= position
                    if (position == 2) {
                        binding.tvNext.visibility= View.INVISIBLE
                        binding.tvSkip.visibility= View.INVISIBLE
                        binding.dotsIndicator.visibility= View.INVISIBLE
                        binding.btGetStarted.visibility = View.VISIBLE
                    } else {
                        binding.tvNext.visibility= View.VISIBLE
                        binding.tvSkip.visibility= View.VISIBLE
                        binding.dotsIndicator.visibility= View.VISIBLE
                        binding.btGetStarted.visibility = View.INVISIBLE

                    }
                }
            })
        } catch (e: Exception) {

        }
    }

}