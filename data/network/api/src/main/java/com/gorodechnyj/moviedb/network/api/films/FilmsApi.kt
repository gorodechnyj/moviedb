package com.gorodechnyj.moviedb.network.api.films

import com.gorodechnyj.moviedb.network.api.dto.FilmDTO
import com.gorodechnyj.moviedb.network.api.dto.FilmSearchByFiltersResponseDTO
import com.gorodechnyj.moviedb.network.api.dto.FilmSortOrder
import com.gorodechnyj.moviedb.network.api.dto.FilmType
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FilmsApi {

    @GET("/api/v2.2/films/{id}")
    suspend fun getFilm(@Path("id") id: Int): FilmDTO

    @GET("/api/v2.2/films")
    @Suppress("LongParameterList")
    suspend fun getFilms(
        @Query("countries") countries: String? = null, // comma separated url array countries=1,2,3
        @Query("genres") genres: String? = null, // comma separated url array countries=1,2,3
        @Query("order") order: FilmSortOrder? = FilmSortOrder.RATING,
        @Query("type") type: FilmType? = FilmType.ALL,
        @Query("ratingFrom") ratingFrom: Int? = 0,
        @Query("ratingTo") ratingTo: Int? = 10,
        @Query("yearFrom") yearFrom: Int? = null,
        @Query("yearTo") yearTo: Int? = null,
        @Query("imdbId") imdbId: String? = null,
        @Query("keyword") keyword: String? = null,
        @Query("page") page: Int = 1
    ): FilmSearchByFiltersResponseDTO
}
