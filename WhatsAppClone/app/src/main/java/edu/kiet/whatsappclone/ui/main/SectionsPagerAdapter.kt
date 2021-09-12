package edu.kiet.whatsappclone.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import edu.kiet.whatsappclone.R
import edu.kiet.whatsappclone.ui.main.call.CallsFragments



class SectionsPagerAdapter(val fm: FragmentManager, val lifecycle: Lifecycle) :   FragmentStateAdapter(fm,lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position)
        {
            0-> return PlaceholderFragment.newInstance(position + 1)
            1->return PlaceholderFragment.newInstance(position + 1)
            2->return CallsFragments()
        }
        return PlaceholderFragment.newInstance(position + 1)
    }
}