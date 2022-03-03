package com.nisith.kotlindemoapp1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nisith.kotlindemoapp1.Adapters.MyFragmentPagerAdapter
import com.nisith.kotlindemoapp1.Fragments.DrumPadFragment
import com.nisith.kotlindemoapp1.Fragments.MusicFragment

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class HomeActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var themeSwitch: Switch
    private lateinit var drumPadFragment: DrumPadFragment
    private lateinit var mySharedPreference: MySharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val appToolbar: Toolbar = findViewById(R.id.app_toolbar)
        themeSwitch = appToolbar.findViewById(R.id.theme_switch)
        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.view_pager)
        setSupportActionBar(appToolbar)
        title = ""
        setupTabLayoutWithViewPager()
        mySharedPreference = MySharedPreference(this)
        setupSwitchListener()
        setBackgroundTheme()

    }



    private fun setupSwitchListener(){
        themeSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            when(isChecked){
                true -> {
                    //Means DARK THEME switch is enable
                    mySharedPreference.saveBackgroundTheme(Constants.DARK_THEME)
                    drumPadFragment.setBackgroundColor()
                    Log.d("ABCD","TRUE")
                }
                false -> {
                    //Means DARK THEME switch is disable
                    mySharedPreference.saveBackgroundTheme(Constants.LIGHT_THEME)
                    drumPadFragment.setBackgroundColor()
                    Log.d("ABCD","FALSE")
                }
            }
        }
    }

    private fun setBackgroundTheme(){
        val backgroundTheme = mySharedPreference.getSavedBackgroundTheme()
        if(backgroundTheme == Constants.DARK_THEME){
            themeSwitch.isChecked = true
        }else{
            themeSwitch.isChecked = false
        }
    }


    private fun setupTabLayoutWithViewPager(){
        val myFragmentPagerAdapter: MyFragmentPagerAdapter = MyFragmentPagerAdapter(supportFragmentManager)
        viewPager.adapter = myFragmentPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
        drumPadFragment = myFragmentPagerAdapter.getItem(1) as DrumPadFragment
        Log.d("MNBVC","hOME "+drumPadFragment)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.privacy_policy -> {
                Toast.makeText(applicationContext, "Privacy Policy", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }

}