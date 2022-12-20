package com.gorodechnyj.moviedb.catalog.ui

import android.content.Context
import com.gorodechnyj.moviedb.catalog.CatalogState
import com.gorodechnyj.moviedb.catalog.ui.adapter.CatalogItem

data class CatalogViewState(
    val canLoadMore: Boolean,
    val items: List<CatalogItem>
)

class CatalogViewStateMapper(
    val context: Context
) : (CatalogState) -> CatalogViewState {

    override fun invoke(state: CatalogState): CatalogViewState {
        val items = state.items.map {
            CatalogItem.Movie(
                movie = it
            )
        }
        return CatalogViewState(
            canLoadMore = state.lastPage < state.totalPages,
            items = items
        )
    }
}
