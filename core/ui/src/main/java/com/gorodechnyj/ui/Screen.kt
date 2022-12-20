package com.gorodechnyj.ui

import android.app.Activity
import android.os.Build
import android.util.DisplayMetrics
import androidx.annotation.NonNull

fun getScreenWidth(@NonNull activity: Activity): Int {
    activity.resources.configuration.densityDpi
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        activity.resources.configuration.densityDpi
    } else {
        val displayMetrics = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
        displayMetrics.widthPixels
    }
}
