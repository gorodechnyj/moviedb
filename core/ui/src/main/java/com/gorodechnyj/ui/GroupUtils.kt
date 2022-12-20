package com.gorodechnyj.ui

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Group

fun Group.setGroupAlpha(alpha: Float) = referencedIds.forEach {
    (parent as ConstraintLayout).findViewById<View>(it)?.alpha = alpha
}
