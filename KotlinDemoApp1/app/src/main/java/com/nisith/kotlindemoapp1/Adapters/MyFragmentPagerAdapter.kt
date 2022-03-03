package com.nisith.kotlindemoapp1.Adapters


import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.nisith.kotlindemoapp1.Fragments.DrumPadFragment
import com.nisith.kotlindemoapp1.Fragments.MusicFragment

@Suppress("DEPRECATION")
class MyFragmentPagerAdapter( fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        if (position == 1){
            val drumPadFragment = DrumPadFragment()
            Log.d("MNBVC","fragment "+drumPadFragment)
            return drumPadFragment
        }else{
            return MusicFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title: CharSequence = ""
        when(position){
            0 -> {
                title = "DrumPad"
            }
            1 -> {
                title = "All Files"
            }
        }
        return title
    }




}