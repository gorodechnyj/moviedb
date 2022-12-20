package com.gorodechnyj.moviedb.di

import android.app.Application
import com.gorodechnyj.api.ApiAvailability
import com.gorodechnyj.api.ApiAvailabilityResolver
import com.gorodechnyj.api.ServicesApiType
import com.gorodechnyj.api.google.GoogleApiAvailabilityChecker
import com.gorodechnyj.api.huawei.EmuiDataSource
import com.gorodechnyj.api.huawei.HuaweiApiAvailabilityChecker
import com.gorodechnyj.api.huawei.HuaweiEmui10ApiAvailabilityChecker
import com.gorodechnyj.api.huawei.provideEmuiDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ApiAvailabilityModule {

    @Singleton
    @Provides
    fun provideEmuiDataSource(): EmuiDataSource = provideEmuiDataSourceImpl()

    @Singleton
    @Provides
    fun provideApiCheckers(
        application: Application,
        emuiDataSource: EmuiDataSource
    ): Map<ServicesApiType, ApiAvailability.AvailabilityChecker> = mapOf(
        ServicesApiType.GOOGLE_PLAY to GoogleApiAvailabilityChecker(application),
        ServicesApiType.HMS_EMUI_VERSION_10_0 to HuaweiEmui10ApiAvailabilityChecker(
            application,
            emuiDataSource
        ),
        ServicesApiType.HMS to HuaweiApiAvailabilityChecker(application)
    )

    @Singleton
    @Provides
    fun provideApiAvailability(
        checkers: Map<ServicesApiType, @JvmSuppressWildcards ApiAvailability.AvailabilityChecker>
    ): ApiAvailability = ApiAvailabilityResolver(checkers)
}
