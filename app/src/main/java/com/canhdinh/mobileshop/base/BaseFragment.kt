package com.canhdinh.mobileshop.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.canhdinh.mobileshop.R

abstract class BaseFragment(fragmentHome: Int) : Fragment(){

    fun replaceFragment(
        fragmentManager: FragmentManager?,
        containerId: Int,
        fragment: BaseFragment,
        addBackStack: Boolean = true,
        hasAnim: Boolean = true
    ) {
        fragmentManager?.let {
            val ft = it.beginTransaction()
            if (hasAnim) {
                ft.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_left,
                    R.anim.enter_from_left,
                    R.anim.exit_to_right
                )
            }
            ft.replace(containerId, fragment)
            if (addBackStack) {
                ft.addToBackStack(fragment::class.java.canonicalName)
            }
            ft.commit()
        }
    }
    fun addFragment(
        fragmentManager: FragmentManager?,
        containerId: Int,
        fragment: BaseFragment,
        addBackStack: Boolean = true,
        hasAnim: Boolean = true
    ) {
        fragmentManager?.let {
            val ft = it.beginTransaction()
            if (hasAnim) {
                ft.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_left,
                    R.anim.enter_from_left,
                    R.anim.exit_to_right
                )
            }
            ft.add(containerId, fragment)
            if (addBackStack) {
                ft.addToBackStack(fragment::class.java.canonicalName)
            }
            ft.commit()
        }
    }
}