package com.gorodechnyj.moviedb.catalog.di

import android.content.Context
import com.gorodechnyj.core.coroutine.AppDispatchers
import com.gorodechnyj.core.log.Logger
import com.gorodechnyj.moviedb.catalog.CatalogInteractor
import com.gorodechnyj.moviedb.catalog.CatalogInteractorImpl
import com.gorodechnyj.moviedb.catalog.middleware.LoadPageMiddleware
import com.gorodechnyj.moviedb.catalog.ui.CatalogViewStateMapper
import com.gorodechnyj.moviedb.data.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Module
@InstallIn(ViewModelComponent::class)
internal object CatalogModule {

    @Provides
    @ViewModelScoped
    @OptIn(ExperimentalCoroutinesApi::class)
    fun provideCatalogStoreFactory(
        searchRepository: SearchRepository,
        dispatchers: AppDispatchers,
        logger: Logger
    ): CatalogInteractor.Factory = CatalogInteractorImpl.Factory(
        middlewares = setOf(
            LoadPageMiddleware(
                searchRepository = searchRepository,
                logger = logger
            )
        ),
        dispatchers = dispatchers,
        logger = logger
    )

    @Provides
    @ViewModelScoped
    fun provideCatalogViewStateMapper(
        @ApplicationContext context: Context
    ): CatalogViewStateMapper = CatalogViewStateMapper(
        context = context
    )
}
