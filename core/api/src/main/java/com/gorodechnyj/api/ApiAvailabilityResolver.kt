package com.gorodechnyj.api

class ApiAvailabilityResolver(
    private val checkers: Map<ServicesApiType, ApiAvailability.AvailabilityChecker>
) : ApiAvailability {

    override fun isServicesAvailable(type: ServicesApiType): Boolean =
        checkers[type]?.isServicesAvailable() ?: false
}
