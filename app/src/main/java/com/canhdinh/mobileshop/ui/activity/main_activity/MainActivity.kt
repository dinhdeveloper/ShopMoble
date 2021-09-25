package com.canhdinh.mobileshop.ui.activity.main_activity

import android.os.Bundle
import com.canhdinh.mobileshop.R
import com.canhdinh.mobileshop.base.BaseActivity
import com.canhdinh.mobileshop.databinding.ActivityMainBinding
import com.canhdinh.mobileshop.ui.fragment.home_fragment.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    private fun initFragment() {
        replaceFragment(
            fragmentManager = supportFragmentManager,
            containerId = R.id.container,
            fragment = HomeFragment.newInstance(),
            addBackStack = false
        )
    }
}