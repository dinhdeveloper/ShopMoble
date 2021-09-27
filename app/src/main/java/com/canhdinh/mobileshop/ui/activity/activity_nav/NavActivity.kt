package com.canhdinh.mobileshop.ui.activity.activity_nav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.canhdinh.mobileshop.R
import com.canhdinh.mobileshop.base.BaseActivity
import com.canhdinh.mobileshop.databinding.ActivityNavBinding

class NavActivity :BaseActivity<ActivityNavBinding>() {

    override val layoutResourceId: Int?
        get() = R.layout.activity_nav

    override fun initBaseActivity() {

    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.nav_host).navigateUp()
    }
}