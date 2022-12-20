package com.gorodechnyj.core.log

interface Logger {

    fun w(message: String, e: Throwable? = null)
    fun w(e: Throwable)

    fun d(message: String, e: Throwable? = null)
    fun d(e: Throwable)

    fun e(message: String, e: Throwable? = null)
    fun e(e: Throwable)
}
