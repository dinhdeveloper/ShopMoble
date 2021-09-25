package com.canhdinh.mobileshop.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.canhdinh.mobileshop.R

abstract class BaseFragment<_ViewDataBinding : ViewDataBinding>() : Fragment() {

    abstract val layoutResourceId: Int?
    lateinit var _binding: _ViewDataBinding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = DataBindingUtil.inflate(
            inflater,
            layoutResourceId!!,
            container,
            false
        )
        return binding.root
    }


    fun replaceFragment(
        fragmentManager: FragmentManager?,
        containerId: Int,
        fragment: BaseFragment<_ViewDataBinding>,
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
        fragment: BaseFragment<_ViewDataBinding>,
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