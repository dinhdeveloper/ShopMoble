package com.canhdinh.mobileshop.ui.fragment.loadmore_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.canhdinh.mobileshop.R
import com.canhdinh.mobileshop.adapter.DogsAdapter
import com.canhdinh.mobileshop.adapter.LoaderStateAdapter
import com.canhdinh.mobileshop.base.BaseFragment
import com.canhdinh.mobileshop.databinding.FragmentLoadMoreBinding
import com.canhdinh.mobileshop.ui.fragment.home_fragment.HomeFragment
import com.canhdinh.mobileshop.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class LoadMoreFragment : BaseFragment<FragmentLoadMoreBinding>() {

    @Inject
    lateinit var dogsAdapter: DogsAdapter

    private val mainViewModel: CharacterViewModel by viewModels()
    override val layoutResourceId: Int?
        get() = R.layout.fragment_load_more

    companion object {
        fun newInstance(): LoadMoreFragment {
            return LoadMoreFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()

        lifecycleScope.launchWhenStarted {
            mainViewModel.getAllDogs.collectLatest { response ->
                _binding.apply {
                    progressBar.isVisible = false
                    recyclerview.isVisible = true
                }
                dogsAdapter.submitData(response)
            }
        }
    }

    private fun initRecyclerView() {
        _binding.apply {
            recyclerview.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(context, 2)
                adapter = dogsAdapter.withLoadStateHeaderAndFooter(
                    header = LoaderStateAdapter { dogsAdapter::retry },
                    footer = LoaderStateAdapter { dogsAdapter::retry }
                )
            }
        }
    }

}