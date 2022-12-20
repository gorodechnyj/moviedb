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
 * @param kinopoiskId
 * @param type
 * @param date
 * @param positiveRating
 * @param negativeRating
 * @param author
 * @param title
 * @param description
 */
data class ReviewResponseItems(

    val kinopoiskId: kotlin.Int? = null,
    val type: ReviewResponseItems.Type? = null,
    val date: kotlin.String? = null,
    val positiveRating: kotlin.Int? = null,
    val negativeRating: kotlin.Int? = null,
    val author: kotlin.String? = null,
    val title: kotlin.String? = null,
    val description: kotlin.String? = null
) {
    /**
     *
     * Values: POSITIVE,NEGATIVE,NEUTRAL,UNKNOWN
     */
    enum class Type(val value: kotlin.String) {
        POSITIVE("POSITIVE"),
        NEGATIVE("NEGATIVE"),
        NEUTRAL("NEUTRAL"),
        UNKNOWN("UNKNOWN");
    }
}