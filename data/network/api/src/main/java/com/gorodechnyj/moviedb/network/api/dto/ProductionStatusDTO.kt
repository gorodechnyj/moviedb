package com.gorodechnyj.moviedb.network.api.dto

/**
 *
 * Values: FILMING,PREPRODUCTION,COMPLETED,ANNOUNCED,UNKNOWN,POSTPRODUCTION
 */
enum class ProductionStatusDTO(val value: String?) {
    FILMING("FILMING"),
    PREPRODUCTION("PRE_PRODUCTION"),
    COMPLETED("COMPLETED"),
    ANNOUNCED("ANNOUNCED"),
    UNKNOWN("UNKNOWN"),
    POSTPRODUCTION("POST_PRODUCTION");
}
