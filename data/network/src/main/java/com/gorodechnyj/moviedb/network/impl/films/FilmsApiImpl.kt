package com.gorodechnyj.moviedb.network.impl.films

import com.gorodechnyj.moviedb.network.api.ApiService
import com.gorodechnyj.moviedb.network.api.dto.FilmDTO
import com.gorodechnyj.moviedb.network.api.dto.FilmSearchByFiltersResponseDTO
import com.gorodechnyj.moviedb.network.api.dto.FilmSortOrder
import com.gorodechnyj.moviedb.network.api.dto.FilmType
import com.gorodechnyj.moviedb.network.api.films.FilmsApi

class FilmsApiImpl(
    val apiService: ApiService
) : FilmsApi {

    override suspend fun getFilm(id: Int): FilmDTO {
        return apiService.getFilm(id)
    }

    override suspend fun getFilms(
        countries: String?,
        genres: String?,
        order: FilmSortOrder?,
        type: FilmType?,
        ratingFrom: Int?,
        ratingTo: Int?,
        yearFrom: Int?,
        yearTo: Int?,
        imdbId: String?,
        keyword: String?,
        page: Int
    ): FilmSearchByFiltersResponseDTO {
        return apiService.getFilms(
            countries = countries,
            genres = genres,
            order = order,
            type = type,
            ratingFrom = ratingFrom,
            ratingTo = ratingTo,
            yearFrom = yearFrom,
            yearTo = yearTo,
            imdbId = imdbId,
            keyword = keyword,
            page = page
        )
    }
}
