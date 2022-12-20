package com.gorodechnyj.moviedb.network.api.dto

import java.math.BigDecimal
import kotlinx.serialization.Serializable

/**
 *
 * @param kinopoiskId
 * @param imdbId
 * @param nameRu
 * @param nameEn
 * @param nameOriginal
 * @param countries
 * @param genres
 * @param ratingKinopoisk
 * @param ratingImdb
 * @param year
 * @param type
 * @param posterUrl
 * @param posterUrlPreview
 */
@Serializable
data class FilmSearchByFiltersResponseItemsDTO(

    val kinopoiskId: Int? = null,
    val imdbId: String? = null,
    val nameRu: String? = null,
    val nameEn: String? = null,
    val nameOriginal: String? = null,
    val countries: List<CountryDTO>? = null,
    val genres: List<GenreDTO>? = null,
    val ratingKinopoisk: Float? = null,
    val ratingImdb: Float? = null,
    val year: Float? = null,
    val type: TypeDTO? = null,
    val posterUrl: String? = null,
    val posterUrlPreview: String? = null
)
