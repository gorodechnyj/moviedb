package com.gorodechnyj.moviedb.network.api.dto

/**
 *
 * @param kinopoiskId
 * @param imdbId
 * @param nameRu
 * @param nameEn
 * @param nameOriginal
 * @param posterUrl
 * @param posterUrlPreview
 * @param coverUrl
 * @param logoUrl
 * @param reviewsCount
 * @param ratingGoodReview
 * @param ratingGoodReviewVoteCount
 * @param ratingKinopoisk
 * @param ratingKinopoiskVoteCount
 * @param ratingImdb
 * @param ratingImdbVoteCount
 * @param ratingFilmCritics
 * @param ratingFilmCriticsVoteCount
 * @param ratingAwait
 * @param ratingAwaitCount
 * @param ratingRfCritics
 * @param ratingRfCriticsVoteCount
 * @param webUrl
 * @param year
 * @param filmLength
 * @param slogan
 * @param description
 * @param shortDescription
 * @param editorAnnotation
 * @param isTicketsAvailable
 * @param productionStatus
 * @param type
 * @param ratingMpaa
 * @param ratingAgeLimits
 * @param hasImax
 * @param has3D
 * @param lastSync
 * @param countries
 * @param genres
 * @param startYear
 * @param endYear
 * @param serial
 * @param shortFilm
 * @param completed
 */
data class FilmDTO(

    val kinopoiskId: Int,
    val imdbId: String,
    val nameRu: String,
    val nameEn: String,
    val nameOriginal: String,
    val posterUrl: String,
    val posterUrlPreview: String,
    val coverUrl: String,
    val logoUrl: String,
    val reviewsCount: Int,
    val ratingGoodReview: java.math.BigDecimal,
    val ratingGoodReviewVoteCount: Int,
    val ratingKinopoisk: java.math.BigDecimal,
    val ratingKinopoiskVoteCount: Int,
    val ratingImdb: java.math.BigDecimal,
    val ratingImdbVoteCount: Int,
    val ratingFilmCritics: java.math.BigDecimal,
    val ratingFilmCriticsVoteCount: Int,
    val ratingAwait: java.math.BigDecimal,
    val ratingAwaitCount: Int,
    val ratingRfCritics: java.math.BigDecimal,
    val ratingRfCriticsVoteCount: Int,
    val webUrl: String,
    val year: Int,
    val filmLength: Int,
    val slogan: String,
    val description: String,
    val shortDescription: String,
    val editorAnnotation: String,
    val isTicketsAvailable: Boolean,
    val productionStatus: ProductionStatusDTO,
    val type: TypeDTO,
    val ratingMpaa: String,
    val ratingAgeLimits: String,
    val hasImax: Boolean,
    val has3D: Boolean,
    val lastSync: String,
    val countries: List<CountryDTO>,
    val genres: List<GenreDTO>,
    val startYear: Int,
    val endYear: Int,
    val serial: Boolean? = null,
    val shortFilm: Boolean? = null,
    val completed: Boolean? = null
) {

}
