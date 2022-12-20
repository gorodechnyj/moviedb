package com.gorodechnyj.moviedb.network.di

import android.content.Context
import android.net.ConnectivityManager
import com.gorodechnyj.moviedb.network.AuthHeaderInterceptor
import com.gorodechnyj.network.state.NetworkStateImpl
import com.gorodechnyj.moviedb.network.BuildConfig
import com.gorodechnyj.moviedb.network.api.ApiService
import com.gorodechnyj.moviedb.network.state.NetworkState
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
@Suppress("TooManyFunctions")
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpLogger(): HttpLoggingInterceptor {
        val logBodyInterceptor = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) {
            logBodyInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logBodyInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        return logBodyInterceptor
    }

    @Provides
    @Singleton
    @Named("main")
    fun provideOkhttp(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthHeaderInterceptor())
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideJson(): Json {
        return Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }
    }

    @Singleton
    @Provides
    @Named("main")
    fun provideRetrofit(
        @Named("main") client: OkHttpClient,
        json: Json
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://kinopoiskapiunofficial.tech")
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType())
            )
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun providesApiService(
        @Named("main") retrofit: Retrofit
    ): ApiService = retrofit.create(ApiService::class.java)

    @ExperimentalCoroutinesApi
    @Provides
    @Singleton
    fun providesNetworkConnectionState(
        @ApplicationContext context: Context
    ): NetworkState = NetworkStateImpl(
        context.getSystemService(Context.CONNECTIVITY_SERVICE)
            as ConnectivityManager
    )
}
