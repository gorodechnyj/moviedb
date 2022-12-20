package com.gorodechnyj.ui

import android.view.View
import android.view.ViewGroup

fun ViewGroup.goneUnless(predicate: Boolean) = if (predicate) this.visible() else this.gone()

fun <T : ViewGroup> T.visible() = this.apply { this.visibility = View.VISIBLE }

fun <T : ViewGroup> T.gone() = this.apply { this.visibility = View.GONE }
