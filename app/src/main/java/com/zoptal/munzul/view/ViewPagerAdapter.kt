package com.zoptal.munzul.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter (manager: FragmentManager?, lifecycleOwner: LifecycleOwner) :
    FragmentStateAdapter(manager!!, lifecycleOwner.lifecycle)

{

    private val fragmentList: ArrayList<Fragment> = ArrayList()

    fun addFragment(fragment: Fragment?) {
        fragmentList.add(fragment!!)
    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }
    // Add a method to get a fragment at a specific position
    fun getFragmentAtPosition(position: Int): Fragment? {
        return if (position < fragmentList.size) {
            fragmentList[position]
        } else {
            null
        }
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}