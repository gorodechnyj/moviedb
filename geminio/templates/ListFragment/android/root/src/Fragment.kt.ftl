package ${projectPackage}.${featurePackage}.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gorodechnyj.extensions.launchWhenStarted
import ${projectPackage}.${featurePackage}.R
import ${projectPackage}.${featurePackage}.databinding.FragmentCatalogBinding
import ${projectPackage}.${featurePackage}.ui.adapter.CatalogAdapter
import com.redmadrobot.extensions.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach

private const val LOAD_NEXT_ITEM_COUNT = 2

@AndroidEntryPoint
class ${featureNameCamelCase}Fragment : Fragment(R.layout.fragment_catalog) {

    private val viewModel: ${featureNameCamelCase}ViewModel by viewModels()
    private val binding: FragmentCatalogBinding by viewBinding()

    private lateinit var adapter: ${featureNameCamelCase}Adapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ${featureNameCamelCase}Adapter()
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

        viewModel.viewStateFlow
            .onEach(::handleState)
            .launchWhenStarted(viewLifecycleOwner)
    }

    private fun handleState(state: ${featureNameCamelCase}ViewState) {
        adapter.items = state.items
    }
}
