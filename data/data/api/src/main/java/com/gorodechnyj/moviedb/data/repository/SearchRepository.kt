package com.gorodechnyj.moviedb.data.repository

import com.gorodechnyj.moviedb.data.model.SearchPage

interface SearchRepository {

    suspend fun searchFilms(
        page: Int = 1
    ): SearchPage
}
