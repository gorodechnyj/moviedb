package com.gorodechnyj.moviedb.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.gorodechnyj.core.navigation.Destination
import com.gorodechnyj.core.navigation.Direction
import com.gorodechnyj.core.navigation.GlobalNavAction
import com.gorodechnyj.core.navigation.Navigator
import com.gorodechnyj.moviedb.R
import com.gorodechnyj.moviedb.ui.MainActivity
import kotlin.reflect.KClass

class MainActivityNavigator(
    private val navController: NavController
) : Navigator {

    private val mainNavHost =
        (navController.context as MainActivity).supportFragmentManager.fragments[0]

    @Suppress("ComplexMethod")
    private fun getNavDirection(direction: Direction): NavDirections? = when (direction) {
//        is FromEnterPhone -> direction.toDirection()
//        is FromCheckout -> direction.toDirection()
//        is FromUserAddressList -> direction.toDirection()
//        is OnboardingDestination.ToLogin -> OnboardingFragmentDirections.actionOnboardingToEnterPhone()
//        is OnboardingDestination.ToPreloader -> OnboardingFragmentDirections.actionOnboardingToPreload()
//        is PreloadDestination.ToOnboarding -> PreloadFragmentDirections.actionPreloadToOnboarding()
        else -> null
    }

    override fun execute(action: Direction): Boolean {
        val direction = getNavDirection(action)
        if (direction == null) {
            handleGlobalAction(action)
        } else {
            navController.navigate(direction)
        }
        return true
    }

    override fun up() {
        if (!navController.navigateUp()) {
            (navController.context as MainActivity).onBackPressed()
        }
    }

    override fun back(
        to: KClass<out Destination>?,
        inclusive: Boolean
    ) {
        val popped = if (to != null) {
            val destinationId = when (to) {
//                EnterPhoneDestination::class -> R.id.enter_phone
//                PreloadDestination::class -> R.id.preload
                else -> 0
            }
            if (destinationId > 0) {
                navController.popBackStack(
                    destinationId = destinationId,
                    inclusive = inclusive
                )
            } else {
                navController.popBackStack()
            }
        } else {
            navController.popBackStack()
        }
        if (!popped) {
            (navController.context as MainActivity).onBackPressed()
        }
    }

    private fun handleGlobalAction(action: Direction) {
        when (action) {
            GlobalNavAction.ToMainMenu -> navController.navigate(R.id.toMainMenu)
        }
    }

    companion object {
        private const val ARGS = "args"
    }
}
