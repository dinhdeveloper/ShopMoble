package com.canhdinh.mobileshop.ui.fragment.nav_component

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.canhdinh.mobileshop.R
import com.canhdinh.mobileshop.base.BaseFragment
import com.canhdinh.mobileshop.databinding.FragmentTwoBinding
import com.canhdinh.mobileshop.model.Weight

class TwoFragment : BaseFragment<FragmentTwoBinding>() {

    override val layoutResourceId: Int?
        get() = R.layout.fragment_two

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val controller = findNavController()

        //get data from fragment one
        val bundle = arguments
        if (bundle != null) {
            val weight = bundle?.getSerializable("weight") as Weight
            Log.e("AAAAAAAAAAATWO", "${weight.imperial}    ${weight.metric}")
        }

        _binding.twoToThree.setOnClickListener {
            controller.navigate(R.id.action_twoFragment_to_threeFragment)
        }

        _binding.twoBackOne.setOnClickListener {
            controller.navigate(R.id.action_twoFragment_to_oneFragment)
        }
    }
}