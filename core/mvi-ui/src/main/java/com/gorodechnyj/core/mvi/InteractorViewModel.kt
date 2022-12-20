package com.gorodechnyj.core.mvi

import androidx.lifecycle.ViewModel

open class InteractorViewModel : ViewModel() {

    interface OnClearedListener {
        fun onCleared()
    }

    var onClearedListener: OnClearedListener? = null

    override fun onCleared() {
        onClearedListener?.onCleared()
    }
}
