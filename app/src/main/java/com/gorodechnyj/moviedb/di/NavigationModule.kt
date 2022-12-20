package com.gorodechnyj.moviedb.di

import com.gorodechnyj.core.navigation.Router
import com.gorodechnyj.moviedb.navigation.RouterImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NavigationModule {

    @Provides
    @Singleton
    fun provideRouter(): Router = RouterImpl()
}
