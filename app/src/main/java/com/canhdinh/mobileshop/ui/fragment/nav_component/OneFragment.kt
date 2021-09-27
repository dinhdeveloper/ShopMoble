package com.canhdinh.mobileshop.ui.fragment.nav_component

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.canhdinh.mobileshop.R
import com.canhdinh.mobileshop.base.BaseFragment
import com.canhdinh.mobileshop.databinding.FragmentOneBinding
import com.canhdinh.mobileshop.model.Weight

class OneFragment : BaseFragment<FragmentOneBinding>() {

    override val layoutResourceId: Int?
        get() = R.layout.fragment_one


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val controller = findNavController()

        _binding.oneToTwo.setOnClickListener {
            val weight = Weight("Hello", "123")
            val bundle = bundleOf(
                "weight" to weight
            )
            controller.navigate(R.id.action_oneFragment_to_twoFragment, bundle)
        }

        _binding.oneToThree.setOnClickListener {
            val weight = Weight("TO THREE", "321")
            val bundle = bundleOf(
                "weight" to weight
            )
            controller.navigate(R.id.action_oneFragment_to_threeFragment, bundle)
        }
    }


}