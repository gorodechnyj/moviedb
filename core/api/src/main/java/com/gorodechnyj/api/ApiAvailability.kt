package com.gorodechnyj.api

import com.gorodechnyj.api.market.MarketChecker
import com.gorodechnyj.api.market.MarketType

interface ApiAvailability {
    fun isServicesAvailable(type: ServicesApiType): Boolean

    interface AvailabilityChecker {
        fun isServicesAvailable(): Boolean
    }
}

interface Initializer

inline fun <T : Initializer> serviceFactory(
    apiAvailability: ApiAvailability,
    crossinline googleBlock: () -> T,
    crossinline huaweiBlock: () -> T
): T = when {
    apiAvailability.isServicesAvailable(ServicesApiType.HMS_EMUI_VERSION_10_0) -> {
        huaweiBlock()
    }
    apiAvailability.isServicesAvailable(ServicesApiType.GOOGLE_PLAY) -> {
        googleBlock()
    }
    apiAvailability.isServicesAvailable(ServicesApiType.HMS) -> {
        huaweiBlock()
    }
    else -> {
        googleBlock()
    }
}

inline fun <T : Initializer> marketAwareServiceFactory(
    apiAvailability: ApiAvailability,
    marketChecker: MarketChecker,
    crossinline googleBlock: () -> T,
    crossinline huaweiBlock: () -> T
): T = when (marketChecker.checkMarket()) {
    MarketType.GOOGLE_PLAY_MARKET -> googleBlock()
    MarketType.HUAWEI_APP_GALLERY,
    MarketType.UNKNOWN -> serviceFactory(
        apiAvailability = apiAvailability,
        googleBlock = googleBlock,
        huaweiBlock = huaweiBlock
    )
}
