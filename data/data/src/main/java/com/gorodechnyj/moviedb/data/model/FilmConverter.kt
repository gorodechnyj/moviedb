package com.gorodechnyj.moviedb.data.model

import com.gorodechnyj.moviedb.network.api.dto.CountryDTO
import com.gorodechnyj.moviedb.network.api.dto.FilmDTO
import com.gorodechnyj.moviedb.network.api.dto.GenreDTO
import com.gorodechnyj.moviedb.network.api.dto.ProductionStatusDTO
import com.gorodechnyj.moviedb.network.api.dto.TypeDTO

fun FilmDTO.toDomain(): Film = Film(
    kinopoiskId = kinopoiskId,
    imdbId = imdbId,
    nameRu = nameRu,
    nameEn = nameEn,
    nameOriginal = nameOriginal,
    posterUrl = posterUrl,
    posterUrlPreview = posterUrlPreview,
    coverUrl = coverUrl,
    logoUrl = logoUrl,
    reviewsCount = reviewsCount,
    ratingGoodReview = ratingGoodReview,
    ratingGoodReviewVoteCount = ratingGoodReviewVoteCount,
    ratingKinopoisk = ratingKinopoisk,
    ratingKinopoiskVoteCount = ratingGoodReviewVoteCount,
    ratingImdb = ratingImdb,
    ratingImdbVoteCount = ratingImdbVoteCount,
    ratingFilmCritics = ratingFilmCritics,
    ratingFilmCriticsVoteCount = ratingFilmCriticsVoteCount,
    ratingAwait = ratingAwait,
    ratingAwaitCount = ratingAwaitCount,
    ratingRfCritics = ratingRfCritics,
    ratingRfCriticsVoteCount = ratingRfCriticsVoteCount,
    webUrl = webUrl,
    year = year,
    filmLength = filmLength,
    slogan = slogan,
    description = description,
    shortDescription = shortDescription,
    editorAnnotation = editorAnnotation,
    isTicketsAvailable = isTicketsAvailable,
    productionStatus = productionStatus.toDomain(),
    type = type.toDomain(),
    ratingMpaa = ratingMpaa,
    ratingAgeLimits = ratingAgeLimits,
    hasImax = hasImax,
    has3D = has3D,
    lastSync = lastSync,
    countries = countries.map { it.toDomain() },
    genres = genres.map { it.toDomain() },
    startYear = startYear,
    endYear = endYear,
    serial = serial,
    shortFilm = shortFilm,
    completed = completed
)

fun ProductionStatusDTO.toDomain() = when (this) {
    ProductionStatusDTO.FILMING -> ProductionStatus.FILMING
    ProductionStatusDTO.PREPRODUCTION -> ProductionStatus.PREPRODUCTION
    ProductionStatusDTO.COMPLETED -> ProductionStatus.COMPLETED
    ProductionStatusDTO.ANNOUNCED -> ProductionStatus.ANNOUNCED
    ProductionStatusDTO.UNKNOWN -> ProductionStatus.UNKNOWN
    ProductionStatusDTO.POSTPRODUCTION -> ProductionStatus.POSTPRODUCTION
}

fun TypeDTO.toDomain() = when (this) {
    TypeDTO.FILM -> Type.FILM
    TypeDTO.VIDEO -> Type.VIDEO
    TypeDTO.TVSERIES -> Type.TVSERIES
    TypeDTO.MINISERIES -> Type.MINISERIES
    TypeDTO.TVSHOW -> Type.TVSHOW
}

fun CountryDTO.toDomain() = Country(country)

fun GenreDTO.toDomain() = Genre(genre)
