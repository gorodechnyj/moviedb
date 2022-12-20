package com.gorodechnyj.moviedb.catalog.middleware

import com.gorodechnyj.core.log.Logger
import com.gorodechnyj.core.mvi.Middleware
import com.gorodechnyj.moviedb.catalog.CatalogEffect
import com.gorodechnyj.moviedb.catalog.CatalogSideEffect
import com.gorodechnyj.moviedb.catalog.CatalogState
import com.gorodechnyj.moviedb.data.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class LoadPageMiddleware(
    val searchRepository: SearchRepository,
    val logger: Logger
) : Middleware<CatalogEffect, CatalogState, CatalogSideEffect>() {
    override fun invoke(
        effects: Flow<CatalogEffect>,
        states: Flow<CatalogState>
    ) = effects
        .filterIsInstance<CatalogEffect.LoadNextPage>()
        .map {
            val state = states.first()
            if (state.lastPage < state.totalPages) {
                loadPage(state.lastPage + 1)
            } else {
                CatalogEffect.Idle
            }
        }

    private suspend fun loadPage(nextPage: Int = 1): CatalogEffect {
        return try {
            val firstPage = searchRepository.searchFilms(page = nextPage)
            CatalogEffect.PageLoaded(
                items = firstPage.items,
                page = nextPage,
                totalPages = firstPage.totalPages
            )
        } catch (e: Throwable) {
            logger.e(e)
            CatalogEffect.PageLoadFailure(e)
        }
    }
}
