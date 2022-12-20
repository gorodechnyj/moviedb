package com.gorodechnyj.moviedb.network.api.dto

/**
 *
 * Values: FILM,VIDEO,TVSERIES,MINISERIES,TVSHOW
 */
enum class TypeDTO(val value: String) {
    FILM("FILM"),
    VIDEO("VIDEO"),
    TVSERIES("TV_SERIES"),
    MINISERIES("MINI_SERIES"),
    TVSHOW("TV_SHOW");
}
