package edu.kiet.tabexample.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(var fm: FragmentManager, var lifecycle:Lifecycle) :    FragmentStateAdapter(fm,lifecycle) {


       override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return PlaceholderFragment()
            1 -> return PlaceholderFragment()
            2 -> return CallFragment()

        }
        return PlaceholderFragment()
    }


}