package com.gorodechnyj.ui

import android.view.View

fun View.goneUnless(predicate: Boolean) = if (predicate) this.visible() else this.gone()

fun <T : View> T.visible() = this.apply { this.visibility = View.VISIBLE }

fun <T : View> T.gone() = this.apply { this.visibility = View.GONE }
