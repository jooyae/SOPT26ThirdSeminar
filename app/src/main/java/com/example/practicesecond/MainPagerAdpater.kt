package com.example.practicesecond

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainPagerAdpater (fm:FragmentManager): FragmentPagerAdapter (fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0->HomeFragment()
            1->LibraryFragment()
            else-> MypageFragment()
        }//To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount() = 3
}