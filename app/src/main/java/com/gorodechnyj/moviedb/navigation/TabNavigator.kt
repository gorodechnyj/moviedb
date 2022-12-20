package com.gorodechnyj.moviedb.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.gorodechnyj.core.navigation.Destination
import com.gorodechnyj.core.navigation.Direction
import com.gorodechnyj.core.navigation.Navigator
import kotlin.reflect.KClass

class TabNavigator(
    private val parent: MainActivityNavigator,
    private val navController: NavController
) : Navigator {

    @Suppress("ComplexMethod")
    private fun getNavDirection(direction: Direction): NavDirections? = when (direction) {
//        is FromCart -> direction.toDirection()
//        is FromCatalog -> direction.toDirection()
//        is FromCategory -> direction.toDirection()
//        is FromCatalogSearch -> direction.toDirection()
//        is FromUserAddressList -> direction.toDirection()
//        is FromProductList -> direction.toDirection()
//        is FromProductDetails -> direction.toDirection()
//        is FromReviewList -> direction.toDirection()
//        is FromConfirmPhone -> direction.toDirection()
//        is FromPersonalInfo -> direction.toDirection()
//        is FromProfile -> direction.toDirection()
//        is FromFavorites -> direction.toDirection()
//        is FromOrderList -> direction.toDirection()
//        is FromOrderDetails -> direction.toDirection()
//        is FromRequestCode -> direction.toDirection()
//        is FromEnterNewPhone -> direction.toDirection()
//        is FromAboutApp -> direction.toDirection()
//        is FromCancelOrder -> direction.toDirection()
        else -> null
    }

    override fun execute(action: Direction): Boolean {
        val direction = getNavDirection(action)
        return if (direction == null) {
            parent.execute(action)
        } else {
            try {
                navController.navigate(direction)
                true
            } catch (e: IllegalStateException) {
                // there is no current navigation node
//                logger.e(e)
                parent.execute(action)
            } catch (e: IllegalArgumentException) {
                // the desired destination cannot be found from the current destination)
//                logger.e(e)
                parent.execute(action)
            }
        }
    }

    override fun up() {
        navController.navigateUp()
    }

    override fun back(
        to: KClass<out Destination>?,
        inclusive: Boolean
    ) {
        navController.popBackStack()
    }
}
