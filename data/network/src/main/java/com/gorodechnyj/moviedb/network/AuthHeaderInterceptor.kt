package com.gorodechnyj.moviedb.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder().apply {
            addHeader("X-API-KEY", "db4cad26-3a2b-44c0-93b8-62be8ef26485")
        }.build()
        if (!chain.call().isCanceled()) {
            return chain.proceed(newRequest)
        } else {
            return chain.proceed(request)
        }
    }
}
