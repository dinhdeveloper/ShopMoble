package com.canhdinh.mobileshop.ui.fragment.nav_component

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.canhdinh.mobileshop.R
import com.canhdinh.mobileshop.base.BaseFragment
import com.canhdinh.mobileshop.databinding.FragmentThreeBinding
import com.canhdinh.mobileshop.model.Weight


class ThreeFragment : BaseFragment<FragmentThreeBinding>() {

    override val layoutResourceId: Int?
        get() = R.layout.fragment_three

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val controller = findNavController()

        //get data from fragment one
        val bundle = arguments
        if (bundle != null) {
            val weight = bundle?.getSerializable("weight") as Weight
            Log.e("AAAAAAAAAAATHREE", "${weight.imperial}    ${weight.metric}")
        }


        _binding.threeBackOne.setOnClickListener {
            controller.popBackStack(R.id.oneFragment, false)
        }

        _binding.threeBackTwo.setOnClickListener {
            controller.popBackStack(R.id.twoFragment, false)
        }
    }
}