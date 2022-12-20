/**
 * Kinopoisk Unofficial API
 * Kinopoisk Unofficial API предоставляет доступ к данным сайта https://www.kinopoisk.ru. Для доступа вы должны получить токен, который будет доступен после регистрации на <a href=\"https://kinopoiskapiunofficial.tech\">https://kinopoiskapiunofficial.tech</a> </br> <b>Ограничения:</b>  лимитов на общее кол-во запросов нет. Но есть на кол-во запросов в секунду. </br> Каждый пользователь имеет ограничение в <b>20 req/sec</b>. </br> <b>Некоторые</b> эндпоинты имеют свои собственные ограничения, они указаны в описании для статуса <b>429</b>. </br>
 *
 * OpenAPI spec version: 2.0.1
 * Contact: support@kinopoiskapiunofficial.tech
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
package com.gorodechnyj.moviedb.network.api.dto

/**
 *
 * @param filmId
 * @param nameRu
 * @param nameEn
 * @param type
 * @param year
 * @param description
 * @param filmLength
 * @param countries
 * @param genres
 * @param rating
 * @param ratingVoteCount
 * @param posterUrl
 * @param posterUrlPreview
 */
data class FilmSearchResponseFilms(

    val filmId: kotlin.Int? = null,
    val nameRu: kotlin.String? = null,
    val nameEn: kotlin.String? = null,
    val type: FilmSearchResponseFilms.Type? = null,
    val year: kotlin.String? = null,
    val description: kotlin.String? = null,
    val filmLength: kotlin.String? = null,
    val countries: kotlin.Array<CountryDTO>? = null,
    val genres: kotlin.Array<GenreDTO>? = null,
    val rating: kotlin.String? = null,
    val ratingVoteCount: kotlin.Int? = null,
    val posterUrl: kotlin.String? = null,
    val posterUrlPreview: kotlin.String? = null
) {
    /**
     *
     * Values: FILM,TVSHOW,UNKNOWN
     */
    enum class Type(val value: kotlin.String) {
        FILM("FILM"),
        TVSHOW("TV_SHOW"),
        UNKNOWN("UNKNOWN");
    }
}
