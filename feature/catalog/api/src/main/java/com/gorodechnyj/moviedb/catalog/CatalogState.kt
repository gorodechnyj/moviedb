package com.gorodechnyj.moviedb.catalog

import com.gorodechnyj.moviedb.data.model.SearchItem

data class CatalogState(
    val items: List<SearchItem> = listOf(),
    val lastPage: Int = 0,
    val totalPages: Int = Int.MAX_VALUE,
    val loading: Boolean = true,
    val loadError: Throwable? = null
)
