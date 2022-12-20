package com.gorodechnyj.moviedb.data.repository

import com.gorodechnyj.moviedb.data.model.SearchPage
import com.gorodechnyj.moviedb.data.model.toDomain
import com.gorodechnyj.moviedb.network.api.films.FilmsApi

class SearchRepositoryImpl(
    val api: FilmsApi
) : SearchRepository {

    override suspend fun searchFilms(page: Int): SearchPage {
        return api.getFilms(page = page).toDomain()
    }
}
