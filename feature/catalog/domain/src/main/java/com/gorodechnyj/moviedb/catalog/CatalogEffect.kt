package com.gorodechnyj.moviedb.catalog

import com.gorodechnyj.moviedb.data.model.SearchItem

sealed class CatalogEffect {
    object Init : CatalogEffect()
    object Idle : CatalogEffect()
    object LoadNextPage : CatalogEffect()

    data class PageLoaded(
        val items: List<SearchItem>,
        val page: Int,
        val totalPages: Int
    ) : CatalogEffect()

    data class PageLoadFailure(
        val e: Throwable
    ) : CatalogEffect()
}
