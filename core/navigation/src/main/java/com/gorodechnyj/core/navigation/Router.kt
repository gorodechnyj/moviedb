package com.gorodechnyj.core.navigation

import kotlin.reflect.KClass

interface Router {

    fun execute(action: Direction)

    fun up()

    fun back(
        to: KClass<out Destination>? = null,
        inclusive: Boolean = false
    )

    fun bind(navigator: Navigator)

    fun unbind(navigator: Navigator)
}

interface Navigator {

    fun execute(action: Direction): Boolean

    fun up()

    fun back(
        to: KClass<out Destination>? = null,
        inclusive: Boolean = false
    )
}
