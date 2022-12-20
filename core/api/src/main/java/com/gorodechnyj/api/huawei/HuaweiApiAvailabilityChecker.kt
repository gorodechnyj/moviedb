package com.gorodechnyj.api.huawei

import android.content.Context
import com.gorodechnyj.api.ApiAvailability
import com.huawei.hms.api.ConnectionResult
import com.huawei.hms.api.HuaweiApiAvailability

class HuaweiApiAvailabilityChecker(
    private val context: Context
) : ApiAvailability.AvailabilityChecker {

    override fun isServicesAvailable() =
        HuaweiApiAvailability.getInstance()
            .isHuaweiMobileServicesAvailable(context) == ConnectionResult.SUCCESS
}
