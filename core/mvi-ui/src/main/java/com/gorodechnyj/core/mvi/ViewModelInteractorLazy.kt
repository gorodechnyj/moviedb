package com.gorodechnyj.core.mvi

import com.gorodechnyj.core.Model
import kotlinx.coroutines.cancel
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified I : Model<*, *, *>> InteractorViewModel.interactors(
    noinline factory: () -> I
): ReadOnlyProperty<Any?, I> {
    return InteractorLazy(
        this,
        factory
    )
}

class InteractorLazy<I : Model<*, *, *>>(
    private val viewModel: InteractorViewModel,
    private val factory: () -> I
) : ReadOnlyProperty<Any?, I> {

    private var cached: I? = null

    private var onClearedListener = object : InteractorViewModel.OnClearedListener {
        override fun onCleared() {
            cached?.cancel()
            cached = null
        }
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): I {
        return cached ?: createInteractor()
    }

    private fun createInteractor(): I {
        val newInteractor = factory()
        viewModel.onClearedListener = onClearedListener
        cached = newInteractor
        return newInteractor
    }
}
