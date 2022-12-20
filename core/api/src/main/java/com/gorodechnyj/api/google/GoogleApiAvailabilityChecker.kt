package com.gorodechnyj.api.google

import android.content.Context
import com.gorodechnyj.api.ApiAvailability
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability

class GoogleApiAvailabilityChecker(
    private val context: Context
) : ApiAvailability.AvailabilityChecker {

    override fun isServicesAvailable() =
        GoogleApiAvailability.getInstance()
            .isGooglePlayServicesAvailable(context) == ConnectionResult.SUCCESS
}
