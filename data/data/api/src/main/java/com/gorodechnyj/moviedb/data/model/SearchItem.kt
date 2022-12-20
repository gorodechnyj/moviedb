package com.gorodechnyj.moviedb.data.model

data class SearchItem(

    val kinopoiskId: Int? = null,
    val imdbId: String? = null,
    val nameRu: String? = null,
    val nameEn: String? = null,
    val nameOriginal: String? = null,
    val countries: List<Country>? = null,
    val genres: List<Genre>? = null,
    val ratingKinopoisk: Float? = null,
    val ratingImdb: Float? = null,
    val year: Float? = null,
    val type: Type? = null,
    val posterUrl: String? = null,
    val posterUrlPreview: String? = null
)
