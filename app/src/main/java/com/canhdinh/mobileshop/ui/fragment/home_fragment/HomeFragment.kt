package com.canhdinh.mobileshop.ui.fragment.home_fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.canhdinh.mobileshop.R
import com.canhdinh.mobileshop.adapter.CategoryAdapter
import com.canhdinh.mobileshop.base.BaseFragment
import com.canhdinh.mobileshop.databinding.FragmentHomeBinding
import com.canhdinh.mobileshop.viewmodel.CategoryViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private lateinit var categoryAdapter: CategoryAdapter
    private val viewModel: CategoryViewModel by viewModels()

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override val layoutResourceId: Int?
        get() = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        categoryAdapter = CategoryAdapter(CategoryAdapter.OnClickListener {
            // TODO: 9/25/2021 click item
        })
        _binding!!.rcCategory.apply {
            adapter = categoryAdapter
            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
        }

        viewModel.categoryResponse.observe(viewLifecycleOwner, { result ->
            categoryAdapter.category = result
        })
    }

}