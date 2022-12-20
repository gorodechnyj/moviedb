package com.gorodechnyj.moviedb.catalog.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gorodechnyj.extensions.launchWhenStarted
import com.gorodechnyj.moviedb.catalog.R
import com.gorodechnyj.moviedb.catalog.databinding.FragmentCatalogBinding
import com.gorodechnyj.moviedb.catalog.ui.adapter.CatalogAdapter
import com.redmadrobot.extensions.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach

private const val LOAD_NEXT_ITEM_COUNT = 2

@AndroidEntryPoint
class CatalogFragment : Fragment(R.layout.fragment_catalog) {

    private val viewModel: CatalogViewModel by viewModels()
    private val binding: FragmentCatalogBinding by viewBinding()

    private lateinit var adapter: CatalogAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CatalogAdapter()
        binding.recyclerView.adapter = adapter

        binding.recyclerView.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    (recyclerView.layoutManager as? LinearLayoutManager)?.let {
                        val lastItemPosition = it.findLastVisibleItemPosition()
                        val itemsCount = it.itemCount
                        if (lastItemPosition >= itemsCount - LOAD_NEXT_ITEM_COUNT) {
                            viewModel.loadMore()
                        }
                    }
                }
            }
        )

        viewModel.catalogFlow
            .onEach(::handleState)
            .launchWhenStarted(viewLifecycleOwner)
    }

    private fun handleState(state: CatalogViewState) {
        adapter.items = state.items
    }
}
