package com.gorodechnyj.moviedb.data.model

import com.gorodechnyj.moviedb.network.api.dto.FilmSearchByFiltersResponseDTO
import com.gorodechnyj.moviedb.network.api.dto.FilmSearchByFiltersResponseItemsDTO

fun FilmSearchByFiltersResponseItemsDTO.toDomain() = SearchItem(
    kinopoiskId = kinopoiskId,
    imdbId = imdbId,
    nameRu = nameRu,
    nameEn = nameEn,
    nameOriginal = nameOriginal,
    countries = countries?.map { it.toDomain() },
    genres = genres?.map { it.toDomain() },
    ratingKinopoisk = ratingKinopoisk,
    ratingImdb = ratingImdb,
    year = year,
    type = type?.toDomain(),
    posterUrl = posterUrl,
    posterUrlPreview = posterUrlPreview
)

fun FilmSearchByFiltersResponseDTO.toDomain() = SearchPage(
    totalPages = totalPages,
    total = total,
    items = items.map {
        it.toDomain()
    }
)
