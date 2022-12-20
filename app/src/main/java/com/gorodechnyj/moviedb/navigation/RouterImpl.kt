package com.gorodechnyj.moviedb.navigation

import com.gorodechnyj.core.navigation.Destination
import com.gorodechnyj.core.navigation.Direction
import com.gorodechnyj.core.navigation.Navigator
import com.gorodechnyj.core.navigation.Router
import kotlin.reflect.KClass

class RouterImpl : Router {

    var stack = ArrayDeque<Navigator>()

    override fun execute(action: Direction) {
        stack.lastOrNull()?.execute(action)
    }

    override fun up() {
        stack.lastOrNull()?.up()
    }

    override fun back(to: KClass<out Destination>?, inclusive: Boolean) {
        stack.lastOrNull()?.back(to, inclusive)
    }

    override fun bind(navigator: Navigator) {
        stack.addLast(navigator)
    }

    override fun unbind(navigator: Navigator) {
        stack.remove(navigator)
    }
}
