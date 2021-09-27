package com.canhdinh.mobileshop.ui.fragment.loadmore_fragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.canhdinh.mobileshop.R
import com.canhdinh.mobileshop.adapter.DogsLoadMoreAdapter
import com.canhdinh.mobileshop.adapter.LoaderStateAdapter
import com.canhdinh.mobileshop.base.BaseFragment
import com.canhdinh.mobileshop.databinding.FragmentLoadMoreBinding
import com.canhdinh.mobileshop.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class LoadMoreFragment : BaseFragment<FragmentLoadMoreBinding>() {

    @Inject
    lateinit var dogsLoadMoreAdapter: DogsLoadMoreAdapter

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
                dogsLoadMoreAdapter.submitData(response)
            }
        }
    }

    private fun initRecyclerView() {
        _binding.apply {
            recyclerview.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(context, 2)
                adapter = dogsLoadMoreAdapter.withLoadStateHeaderAndFooter(
                    header = LoaderStateAdapter { dogsLoadMoreAdapter::retry },
                    footer = LoaderStateAdapter { dogsLoadMoreAdapter::retry }
                )
            }
        }
    }

}