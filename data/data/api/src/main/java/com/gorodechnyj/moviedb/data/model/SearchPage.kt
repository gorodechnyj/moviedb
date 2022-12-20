package com.gorodechnyj.moviedb.data.model

data class SearchPage(
    val totalPages: Int,
    val total: Int,
    val items: List<SearchItem>
)
