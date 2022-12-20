package com.gorodechnyj.api.huawei

import android.annotation.SuppressLint
import android.util.Log

fun provideEmuiDataSourceImpl(): EmuiDataSource =
    EmuiDataSourceImpl()

internal class EmuiDataSourceImpl : EmuiDataSource {
    @Suppress("TooGenericExceptionCaught")
    @SuppressLint("PrivateApi")
    override fun getEmuiApiLevel(): Int? = try {
        val clazz = Class.forName("android.os.SystemProperties")
        val get = clazz.getMethod("getInt", String::class.java, Int::class.java)
        val currentApiLevel = get.invoke(clazz, EMUI_API, UNKNOWN_API_LEVEL) as Int
        currentApiLevel.takeIf { it != UNKNOWN_API_LEVEL }
    } catch (e: Exception) {
        Log.w("EmuiDataSource", "Unable to get EMUI api level", e)
        null
    }
}

private const val EMUI_API = "ro.build.hw_emui_api_level"
private const val UNKNOWN_API_LEVEL = -1
