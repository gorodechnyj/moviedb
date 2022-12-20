package com.gorodechnyj.moviedb.catalog

import com.gorodechnyj.core.mvi.Reducer

class CatalogReducer : Reducer<CatalogEffect, CatalogState> {

    override fun invoke(
        effect: CatalogEffect,
        state: CatalogState
    ) = when (effect) {
        CatalogEffect.Init,
        CatalogEffect.Idle -> state
        CatalogEffect.LoadNextPage -> state.copy(
            loading = true
        )
        is CatalogEffect.PageLoaded -> state.copy(
            items = state.items + effect.items,
            lastPage = effect.page,
            totalPages = effect.totalPages,
            loading = false
        )
        is CatalogEffect.PageLoadFailure -> state.copy(
            loadError = effect.e,
            loading = false
        )
    }
}
