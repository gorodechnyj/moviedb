package com.gorodechnyj.moviedb.di

import com.gorodechnyj.core.coroutine.AppDispatchers
import com.gorodechnyj.core.coroutine.DefaultDispatchers
import com.gorodechnyj.core.log.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object AppModule {

    @Provides
    @Singleton
    fun provideAppDispatchers(): AppDispatchers = DefaultDispatchers

    @Provides
    @Singleton
    fun provideLogger(): Logger = object : Logger {
        override fun w(message: String, e: Throwable?) {
            if (e != null) {
                Timber.w(e, message)
            } else {
                Timber.w(message)
            }
        }

        override fun w(e: Throwable) {
            Timber.w(e)
        }

        override fun d(message: String, e: Throwable?) {
            if (e != null) {
                Timber.d(e, message)
            } else {
                Timber.d(message)
            }
        }

        override fun d(e: Throwable) {
            Timber.d(e)
        }

        override fun e(message: String, e: Throwable?) {
            if (e != null) {
                Timber.e(e, message)
            } else {
                Timber.e(message)
            }
        }

        override fun e(e: Throwable) {
            Timber.e(e)
        }
    }
}
