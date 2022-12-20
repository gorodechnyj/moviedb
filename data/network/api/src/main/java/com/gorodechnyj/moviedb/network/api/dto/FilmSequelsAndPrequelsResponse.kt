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
 * @param nameOriginal
 * @param posterUrl
 * @param posterUrlPreview
 * @param relationType
 */
data class FilmSequelsAndPrequelsResponse(

    val filmId: kotlin.Int,
    val nameRu: kotlin.String,
    val nameEn: kotlin.String,
    val nameOriginal: kotlin.String,
    val posterUrl: kotlin.String,
    val posterUrlPreview: kotlin.String,
    val relationType: FilmSequelsAndPrequelsResponse.RelationType
) {
    /**
     *
     * Values: SEQUEL,PREQUEL,REMAKE,UNKNOWN
     */
    enum class RelationType(val value: kotlin.String) {
        SEQUEL("SEQUEL"),
        PREQUEL("PREQUEL"),
        REMAKE("REMAKE"),
        UNKNOWN("UNKNOWN");
    }
}