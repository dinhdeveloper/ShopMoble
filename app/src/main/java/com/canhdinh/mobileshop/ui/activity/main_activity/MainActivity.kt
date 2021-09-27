package com.canhdinh.mobileshop.ui.activity.main_activity

import android.os.Bundle
import com.canhdinh.mobileshop.R
import com.canhdinh.mobileshop.base.BaseActivity
import com.canhdinh.mobileshop.databinding.ActivityMainBinding
import com.canhdinh.mobileshop.ui.fragment.home_fragment.HomeFragment
import com.canhdinh.mobileshop.ui.fragment.loadmore_fragment.LoadMoreFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutResourceId: Int?
        get() = R.layout.activity_main

    override fun initBaseActivity() {
        initFragment()
    }

    private fun initFragment() {
        replaceFragment(
            fragmentManager = supportFragmentManager,
            containerId = R.id.container,
            fragment = LoadMoreFragment.newInstance(),
            addBackStack = false
        )
    }


}