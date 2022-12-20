package com.gorodechnyj.moviedb.data.di

import com.gorodechnyj.moviedb.data.repository.SearchRepository
import com.gorodechnyj.moviedb.data.repository.SearchRepositoryImpl
import com.gorodechnyj.moviedb.network.api.films.FilmsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideSearchRepository(
        api: FilmsApi
    ): SearchRepository = SearchRepositoryImpl(api)
}
