package com.gorodechnyj.ui

import android.view.ViewGroup

var ViewGroup.layoutHeight: Int
    get() {
        return layoutParams.height
    }
    set(value) {
        val lp = layoutParams
        lp.height = value
        layoutParams = lp
    }
