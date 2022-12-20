package com.gorodechnyj.api.huawei

import android.content.Context
import com.gorodechnyj.api.ApiAvailability
import com.huawei.hms.api.ConnectionResult
import com.huawei.hms.api.HuaweiApiAvailability

class HuaweiEmui10ApiAvailabilityChecker(
    private val context: Context,
    private val emuiDataSource: EmuiDataSource
) : ApiAvailability.AvailabilityChecker {

    override fun isServicesAvailable() =
        HuaweiApiAvailability.getInstance()
            .isHuaweiMobileServicesAvailable(context) == ConnectionResult.SUCCESS &&
            emuiVersionAtLeast10()

    private fun emuiVersionAtLeast10() =
        emuiDataSource.getEmuiApiLevel()?.let { it >= EMUI_VERSION_10_0_API_LEVEL } == true
}

// EmotionUI_10.0.0 соответсвует ro.build.hw_emui_api_level=21
private const val EMUI_VERSION_10_0_API_LEVEL = 21
