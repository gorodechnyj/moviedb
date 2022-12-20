package com.gorodechnyj.moviedb.network.di

import com.gorodechnyj.moviedb.network.api.ApiService
import com.gorodechnyj.moviedb.network.api.films.FilmsApi
import com.gorodechnyj.moviedb.network.impl.films.FilmsApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Singleton

@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
class NetworkApiModule {

    @Provides
    @Singleton
    fun provideFilmsApi(
        apiService: ApiService
    ): FilmsApi = FilmsApiImpl(apiService)
}
